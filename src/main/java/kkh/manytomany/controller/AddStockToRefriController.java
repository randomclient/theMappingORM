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
import org.springframework.web.servlet.ModelAndView;

import kkh.manytomany.entity.AddStockToRefriDTO;
import kkh.manytomany.entity.MiniRefrigeratorDTO;
import kkh.manytomany.entity.MiniStockDTO;
import kkh.manytomany.model.AddStockToRefriBean;
import kkh.manytomany.service.AddStockToRefriService;
import kkh.manytomany.service.MiniRefrigeratorService;
import kkh.manytomany.service.MiniStockService;

@Controller
@RequestMapping("/ministock")
public class AddStockToRefriController {

	@Autowired
	private MiniStockService miniStockService;

	@Autowired
	private MiniRefrigeratorService miniRefrigeratorService;

	@Autowired
	private AddStockToRefriService addStockToRefriService;

	@GetMapping("/addRefri2Stock")
	public ModelAndView showAddStockToRefri(ModelMap map) {
		List<MiniRefrigeratorDTO> refriList = miniRefrigeratorService.findAll();
		List<MiniStockDTO> stockList = miniStockService.findAll();
		List<AddStockToRefriDTO> srList = addStockToRefriService.findAll();

		map.addAttribute("refriList", refriList);
		map.addAttribute("stockList", stockList);
		map.addAttribute("srList", srList);

		AddStockToRefriBean bean = new AddStockToRefriBean();

		return new ModelAndView("HMS-MRF-02", "Refri2Stock", bean);
	}

	@PostMapping("/addRefri2Stock")
	public String addRefri2Stock(@ModelAttribute("Refri2Stock") @Validated AddStockToRefriBean bean, BindingResult br,
			ModelMap map) {
		if (br.hasErrors()) {
			return "HMS-MRF-02";
		}

		AddStockToRefriDTO dto = new AddStockToRefriDTO();

		dto.setRefrigeratorId(bean.getRefrigeratorId());
		dto.setStockName(bean.getStockName());
		dto.setStockQty(bean.getStockQty());

		/*
		 * get the particular stock(entity class) Object that the owner side of
		 * relationship with m2m annotation
		 */
		MiniStockDTO msDto = miniStockService.findByName(bean.getStockName());
		
		// get total quantity of the particular stock class
		int totalQty = msDto.getQty();
		
		// get current quantity of stock of the front-end bean
		int currentQty = Integer.parseInt(bean.getStockQty());

		if (currentQty <= totalQty) {

			if (addStockToRefriService.isStockExist(dto.getRefrigeratorId(), dto.getStockName())) {
				AddStockToRefriDTO srDto = addStockToRefriService.findByIdAndName(bean.getRefrigeratorId(),
						bean.getStockName());
				System.out.println(srDto);
				Integer prevQty = Integer.parseInt(srDto.getStockQty());

				// update existing row of stock_to_refri
				addStockToRefriService.updateQty((Integer.parseInt(bean.getStockQty()) + prevQty),
						bean.getRefrigeratorId(), bean.getStockName());
			} else {
				// set the particular refrigerator object to the above stock class
				List<MiniRefrigeratorDTO> list = new ArrayList<>();
				list.add(miniRefrigeratorService.getObjById(bean.getRefrigeratorId()));
				
				msDto.getRefrigerator().addAll(list);
				// msDto.setRefrigerator(miniRefrigeratorService.findById(bean.getRefrigeratorId()));

				// update stock
				miniStockService.save(msDto);

				// update stock_to_refri
				addStockToRefriService.insert(dto);

			}

			int newQty = totalQty - currentQty;
			msDto.setQty(newQty);
			miniStockService.update(msDto, msDto.getStockId());

		} else {
			map.addAttribute("msg", "Total stock quantity is " + msDto.getQty());
		}

		return "redirect:/ministock/addRefri2Stock";
	}
}
