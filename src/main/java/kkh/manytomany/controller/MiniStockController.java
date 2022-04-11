package kkh.manytomany.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import kkh.manytomany.entity.AddStockToRefriDTO;
import kkh.manytomany.entity.MiniRefrigeratorDTO;
import kkh.manytomany.entity.MiniStockDTO;
import kkh.manytomany.model.AddStockToRefriBean;
import kkh.manytomany.model.MiniStockBean;
import kkh.manytomany.repository.MiniStockRepository;
import kkh.manytomany.service.AddStockToRefriService;
import kkh.manytomany.service.MiniRefrigeratorService;
import kkh.manytomany.service.MiniStockService;

@Controller
@RequestMapping("/ministock")
public class MiniStockController {
	@Autowired
	private MiniStockService miniStockService;

	@Autowired
	private MiniRefrigeratorService miniRefrigeratorService;
	
	@Autowired
	private AddStockToRefriService addStockToRefriService;

	@GetMapping("/addStock")
	public String addMiniStock(ModelMap map) {
		map.addAttribute("miniStock", new MiniStockBean());
		return "HMS-MS-01";
	}

	@PostMapping("/setUpAddStock")
	public String setUpAddMiniStock(@ModelAttribute("miniStock") MiniStockBean miniStock, ModelMap map) {
		MiniStockDTO dto = new MiniStockDTO();
		List<MiniStockDTO> list = miniStockService.select();
		List<MiniStockDTO> milist = miniStockService.findByid(dto.getStockId());
		dto.setStockId(miniStock.getStockId());
		dto.setName(miniStock.getName());
		dto.setQty(miniStock.getQty());
		dto.setPrice(miniStock.getPrice());
		dto.setStatus("enable");
		if (milist.size() == 0) {
			if (list.size() == 0) {
				miniStock.setStockId("SN0001");
				dto.setStockId(miniStock.getStockId());
			} else {
				int i = list.size() + 1;
				String value = String.format("SN%04d", i++);
				miniStock.setStockId(value);
				dto.setStockId(miniStock.getStockId());
			}
			map.addAttribute("success", "Added Successfully");
			miniStockService.save(dto);
		} else {
			map.addAttribute("error", "Stock Already Exist");
		}
		return "HMS-MS-01";
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

	@GetMapping("/addRefri2Stock")
	public ModelAndView showAddStockToRefri(ModelMap map) {
		List<MiniRefrigeratorDTO> refriList = miniRefrigeratorService.findAll();
		List<MiniStockDTO> stockList = miniStockService.findAll();

		map.addAttribute("refriList", refriList);
		map.addAttribute("stockList", stockList);

		AddStockToRefriBean bean = new AddStockToRefriBean();

		return new ModelAndView("HMS-MRF-02", "bean", bean);
	}

	@PostMapping("/addRefri2Stock")
	public String addRefri2Stock(@ModelAttribute("bean") AddStockToRefriBean bean, BindingResult br, ModelMap map) {
		if(br.hasErrors()) {
			return "HMS-MRF-02";
		}
		
		AddStockToRefriDTO dto = new AddStockToRefriDTO();
		
		dto.setRefrigeratorId(bean.getRefrigeratorId());
		dto.setStockName(bean.getStockName());
		dto.setStockQty(bean.getStockQty());
		addStockToRefriService.insert(dto);
		
		//get particular stock(entity class) Object that the owner of relationship with m2m annotation
		MiniStockDTO msDto = miniStockService.findByName(bean.getStockName());
		
		//set the particular refrigerator object to the above stock class
		List<MiniRefrigeratorDTO> list = new ArrayList<>();
		list.add(miniRefrigeratorService.getObjById(bean.getRefrigeratorId()));
		msDto.getRefrigerator().addAll(list);
//		msDto.setRefrigerator(miniRefrigeratorService.findById(bean.getRefrigeratorId()));
		
		//update stock
		miniStockService.save(msDto);
		
		return "redirect:/ministock/addRefri2Stock";
	}
}
