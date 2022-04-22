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

import kkh.manytomany.entity.AddStockToRoomDTO;
import kkh.manytomany.entity.MiniStockDTO;
import kkh.manytomany.entity.RoomDTO;
import kkh.manytomany.model.AddStockToRefriBean;
import kkh.manytomany.model.AddStockToRoomBean;
import kkh.manytomany.service.AddStockToRoomService;
import kkh.manytomany.service.MiniStockService;
import kkh.manytomany.service.RoomService;

@Controller
@RequestMapping(value="/room")
public class AddStockToRoomController {
	
	@Autowired
	private MiniStockService miniStockService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private AddStockToRoomService addStockToRoomService;
	
	@GetMapping("/add-stock-to-room")
	public ModelAndView showAddStockToRoomPage(ModelMap map) {
		List<RoomDTO> roomList = roomService.findAll();
		List<MiniStockDTO> stockList = miniStockService.findAll();
		List<AddStockToRoomDTO> srList = addStockToRoomService.findAll();

		map.addAttribute("roomList", roomList);
		map.addAttribute("stockList", stockList);
		map.addAttribute("srList", srList);

		AddStockToRoomBean bean = new AddStockToRoomBean();

		return new ModelAndView("HMS-MSROM01", "StockToRoom", bean);
	}

	@PostMapping("/add-stock-to-room")
	public String addRefri2Stock(@ModelAttribute("StockToRoom") @Validated AddStockToRoomBean bean, BindingResult br,
			ModelMap map) {
		if (br.hasErrors()) {
			return "HMS-MSROM01";
		}

		AddStockToRoomDTO dto = new AddStockToRoomDTO();

		dto.setRoomNumber(bean.getRoomNumber());
		dto.setBrandName(bean.getBrandName());
		dto.setStockQty(bean.getStockQty());

		/*
		 * get the particular stock(entity class) Object that the owner side of
		 * relationship with m2m annotation
		 */
		MiniStockDTO msDto = miniStockService.findByName(bean.getBrandName());
		System.out.println(msDto);
		
		// get total quantity of the particular stock class
		int totalQty = msDto.getQty();
		
		// get current quantity of stock of the front-end bean
		int currentQty = Integer.parseInt(bean.getStockQty());

		if (currentQty <= totalQty) {

			if (addStockToRoomService.isStockExist(dto.getRoomNumber(), dto.getBrandName())) {
				AddStockToRoomDTO srDto = addStockToRoomService.findByIdAndName(bean.getRoomNumber(),
						bean.getBrandName());
				System.out.println(srDto);
				Integer prevQty = Integer.parseInt(srDto.getStockQty());

				// update existing row of stock_to_refri
				addStockToRoomService.updateQty((Integer.parseInt(bean.getStockQty()) + prevQty),
						bean.getRoomNumber(), bean.getBrandName());
			} else {
				// set the particular refrigerator object to the above stock class
				List<RoomDTO> list = new ArrayList<>();
				list.add(roomService.getObjById(bean.getRoomNumber()));
				
				msDto.getRoom().addAll(list);
				// msDto.setRefrigerator(miniRefrigeratorService.findById(bean.getRefrigeratorId()));

				// update stock
				miniStockService.save(msDto);

				// update stock_to_room
				addStockToRoomService.insert(dto);

			}

			int newQty = totalQty - currentQty;
			msDto.setQty(newQty);
			miniStockService.update(msDto, msDto.getStockId());

		} else {
			map.addAttribute("msg", "Total stock quantity is " + msDto.getQty());
		}

		return "redirect:/room/add-stock-to-room";
	}
}
