package kkh.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import kkh.manytomany.entity.RoomDTO;
import kkh.manytomany.entity.RoomTypeDTO;
import kkh.manytomany.model.RoomBean;
import kkh.manytomany.service.RoomService;
import kkh.manytomany.service.RoomTypeService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private RoomTypeService roomTypeService;

	@GetMapping("/addRoom")
	public String addRoom(ModelMap map, HttpSession session) {

		List<RoomTypeDTO> list = roomTypeService.findAllRoomTypeStatus();
		// map.addAttribute("rList", list);
		session.setAttribute("rList", list);
		map.addAttribute("room", new RoomBean());
		return "HMS-ROM02";
	}

	@PostMapping("/addRoom")
	public String addRoomSetUp(@ModelAttribute("room") @Validated RoomBean room, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			return "HMS-ROM02";
		}
		RoomDTO dto = new RoomDTO();

		dto.setRoom_status(room.getRoom_status());
		dto.setRoom_desc(room.getRoom_desc());
		dto.setRoomType(room.getRoomType());
		dto.setRoom_cleanstatus(room.getRoom_cleanstatus());
		room.setStatus("enable");
		dto.setStatus(room.getStatus());
		List<RoomDTO> list = roomService.findAll();
		// List<RoomDTO> nlist = roomService.findByNumber(dto.getRoom_number());

		if (list.size() == 0) {
			room.setRoom_number("R0001");
			dto.setRoom_number(room.getRoom_number());
		} else {
			int i = list.size() + 1;
			String value = String.format("R%04d", i++);
			room.setRoom_number(value);
			dto.setRoom_number(room.getRoom_number());
		}
		roomService.save(dto);
		map.addAttribute("success", "Room add Successfully");
		return "HMS-ROM02";
	}

	@GetMapping("/selectRoom")
	public String selectRoom(ModelMap map) {
		List<RoomDTO> list = new ArrayList<RoomDTO>();
		list = roomService.findAllStatus();
		map.addAttribute("rList", list);
		return "HMS-ROM-02";
	}

	@GetMapping("/editRoom")
	public ModelAndView editRoom(@RequestParam("roomno") String roomno, HttpSession session, ModelMap map) {
		RoomDTO dto = new RoomDTO();
		dto.setRoom_number(roomno);
		List<RoomDTO> list = roomService.findByNumber(dto.getRoom_number());
		RoomBean room = new RoomBean();
		for (RoomDTO res : list) {
			room.setRoom_number(res.getRoom_number());
			room.setRoom_status(res.getRoom_status());
			room.setRoom_desc(res.getRoom_desc());
			room.setRoomType(res.getRoomType());

			room.setRoom_cleanstatus(res.getRoom_cleanstatus());
		}
		List<RoomTypeDTO> rlist = roomTypeService.findAllRoomTypeStatus();
		// map.addAttribute("rList", list);
		session.setAttribute("rList", rlist);

		map.addAttribute("room", new RoomBean());
		// map.addAttribute("rList", list);
		return new ModelAndView("HMS-ROM-03", "room", room);
	}

	@PostMapping("/editRoom")
	public String editRoomSetUp(@ModelAttribute("room") @Validated RoomBean room, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			return "HMS-ROM-03";
		}
		RoomDTO dto = new RoomDTO();
		dto.setRoom_number(room.getRoom_number());
		dto.setRoom_status(room.getRoom_status());
		dto.setRoom_desc(room.getRoom_desc());
		dto.setRoomType(room.getRoomType());
		room.setStatus("enable");
		dto.setStatus(room.getStatus());
		dto.setRoom_cleanstatus(room.getRoom_cleanstatus());
		roomService.update(dto, dto.getRoom_number());
		return "redirect:/room/selectRoom";
	}

	@GetMapping("/deleteRoom")
	public String deleteRoom(@RequestParam("roomno") String roomno) {
		RoomDTO dto = new RoomDTO();
		dto.setRoom_number(roomno);
		roomService.updateStatus(roomno);
		return "redirect:/room/selectRoom";
	}

	@GetMapping("/detailRoom")
	public ModelAndView homeRoom(@RequestParam("roomno") String roomno, ModelMap map) {
		RoomDTO dto = new RoomDTO();
		dto.setRoom_number(roomno);
		List<RoomDTO> list = roomService.findByNumber(dto.getRoom_number());
		List<RoomTypeDTO> rtlist = roomTypeService.findAllStatus();
		map.addAttribute("rtList", rtlist);

		map.addAttribute("room", new RoomBean());
		map.addAttribute("rList", list);
		return new ModelAndView("HMS-ROM-04", "room", list.get(0));
	}

	@GetMapping("/homeRoom")
	public String home() {
		return "redirect:/room/selectRoom";
	}
}
