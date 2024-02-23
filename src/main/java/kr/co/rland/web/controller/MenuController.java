package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService service;
	
//	@ResponseBody <- 이거하면 return 값이 그냥 응답임
	@RequestMapping("list")
	public String list(Model model) {
		List<Menu> list = service.getList();
		model.addAttribute("list", list); //<- 여기서 listcontroller에서 jsp로 데이터를 포워딩한것과 같은 현상이 일어난다. model이라는 객체가 데이터를 받은 순간 이미 front 에 값을 포워딩한것과 같음.
		return "web-inf/menu/list.jsp"; //<- 이 주소를 front 로 반환해 사용자가 이 주소를 통해 값이 포워딩된 front에서 값을 받을수있다
	}
//	@ResponseBody
	@RequestMapping("detail")
	public String detail(@RequestParam("id")int id , Model model) {
		Menu menu = service.get(id);
		
		model.addAttribute("menu", menu);
		return "menu/detail";
	}
}
