package kkh.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kkh.manytomany.entity.MiniStockDTO;
import kkh.manytomany.model.MiniStockBean;
import kkh.manytomany.service.MiniStockService;

@Controller
@RequestMapping("/ministock")
public class MiniStockController {
	@Autowired
	private MiniStockService miniStockService;

	@GetMapping("/addStock")
	public String addMiniStock(@ModelAttribute("error")String error,ModelMap map) {
		
		map.addAttribute("error",error);
		
		List<MiniStockDTO> msList = miniStockService.findAll();
		
		MiniStockBean miniStockBean = new MiniStockBean();
		if (msList.size() == 0) {
			miniStockBean.setStockId("SN0001");
		} else {
			String value = String.format("SN%04d", msList.size() + 1);
			miniStockBean.setStockId(value);
		}

		map.addAttribute("msList", msList);
		map.addAttribute("miniStock", miniStockBean);
		return "HMS-MS-01";
	}

	@PostMapping("/setUpAddStock")
	public String setUpAddMiniStock(@ModelAttribute("miniStock") MiniStockBean miniStock,RedirectAttributes redirect, ModelMap map) {
		MiniStockDTO dto = new MiniStockDTO();
		List<MiniStockDTO> list = miniStockService.select();
		List<MiniStockDTO> milist = miniStockService.findByid(dto.getStockId());

		dto.setStockId(miniStock.getStockId());
		dto.setBrandName(miniStock.getBrandName());
		System.out.println(dto.getStockId());
		dto.setSupplier(miniStock.getSupplier());
		dto.setName(miniStock.getName());
		dto.setQty(miniStock.getQty());
		dto.setPrice(miniStock.getPrice());
		dto.setStatus("enable");

		List<MiniStockDTO> isItemExists = miniStockService.getObj(dto.getName(), dto.getBrandName(), dto.getSupplier());

		List<MiniStockDTO> searchList = miniStockService.findByBrandName(dto.getBrandName());
		if (searchList.size() > 0) {
			redirect.addAttribute("error", "Brand Name already exist!!!");
			return "redirect:/ministock/addStock";
		} else {

			map.addAttribute("success", "Added Successfully");
			miniStockService.save(dto);
		}

		return "redirect:/ministock/addStock";
	}

	@GetMapping("/stocklist")
	public String setupshowMiniStockDTO(ModelMap map) {
		List<MiniStockDTO> milist = new ArrayList<>();
		milist = miniStockService.findAllStatus();
		map.addAttribute("milist", milist);
		return "HMS-MS-01";
	}

	@GetMapping("/editStock")
	public ModelAndView selectMiniStock(@RequestParam("stockid") String stockid, ModelMap map) {
		MiniStockDTO dto = new MiniStockDTO();
		dto.setStockId(stockid);
		List<MiniStockDTO> list = miniStockService.findByid(stockid);
		MiniStockBean miniStock = new MiniStockBean();
		for (MiniStockDTO res : list) {
			miniStock.setStockId(res.getStockId());
			miniStock.setName(res.getName());
			miniStock.setQty(res.getQty());
			miniStock.setPrice(res.getPrice());
		}
		return new ModelAndView("HMS-MS-03", "miniStock", miniStock);
	}

	@PostMapping("/editStock")
	public String selectMiniStockSetUp(@ModelAttribute("miniStock") @Validated MiniStockBean miniStock,
			BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			return "HMS-MS-01";
		}
		MiniStockDTO dto = new MiniStockDTO();
		dto.setStockId(miniStock.getStockId());
		dto.setName(miniStock.getName());
		dto.setQty(miniStock.getQty());
		dto.setPrice(miniStock.getPrice());
		dto.setStatus("enable");
		miniStockService.update(dto, dto.getStockId());
		map.addAttribute("success", "Updated Successfully");
		return null;
	}

	@GetMapping("/deleteStock")
	public String deleteMiniStock(@RequestParam("stockid") String stockid, ModelMap map) {
		MiniStockDTO dto = new MiniStockDTO();
		dto.setStockId(stockid);
		miniStockService.updateStatus(stockid);
		return "redirect:/ministock/selectStock";
	}

	@GetMapping("selectStock")
	public String stock(ModelMap map) {
		List<MiniStockDTO> milist = new ArrayList<>();
		milist = miniStockService.findAllStatus();
		map.addAttribute("milist", milist);
		return "HMS-MS-02";
	}

}
