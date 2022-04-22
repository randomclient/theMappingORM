//package kkh.manytomany.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import kkh.manytomany.entity.MiniRefrigeratorDTO;
//import kkh.manytomany.model.MiniRefrigeratorBean;
//import kkh.manytomany.service.MiniRefrigeratorService;
//
//
//@Controller
//@RequestMapping("/minirefrigerator")
//public class MiniRefrigeratorController {
//	@Autowired
//	private MiniRefrigeratorService miniRefrigeratorService;
//
//	@GetMapping("/add")
//	public ModelAndView showMiniRefrigeratorPage() {
//
//		MiniRefrigeratorBean bean = new MiniRefrigeratorBean();
//		List<MiniRefrigeratorDTO> list = miniRefrigeratorService.findAll();
//
////		System.out.println(list.size());
//		
//		if (list.size() == 0) {
//			bean.setMiniRefrigeratorId("MRF0001");
//
//		} else {
//			String value = String.format("MRF%04d", list.size() + 1);
//			bean.setMiniRefrigeratorId(value);
//		}
//
//		return new ModelAndView("HMS-MRF-01", "bean", bean);
//
//	}
//
//	@PostMapping("/add")
//	public String setupMiniRefrigerator(@ModelAttribute("bean") MiniRefrigeratorBean bean, BindingResult br,
//			ModelMap map) {
//		if (br.hasErrors()) {
//			return "HMS-MRF-01";
//		}
//
//		MiniRefrigeratorDTO dto = new MiniRefrigeratorDTO();
//
//		dto.setMiniRefrigeratorId(bean.getMiniRefrigeratorId());
//		dto.setStatus("enable");
//		map.addAttribute("success", "Added Successfully");
//		miniRefrigeratorService.save(dto);
//
//		map.addAttribute("error", "Mini Regfrigerator Id Already Exist");
//
//		return "redirect:/minirefrigerator/add";
//	}
//
//}
