package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		List<User> list = userService.getUserList(0, 10);
		modelMap.addAttribute("userlist", list);
		return "/user/users";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView users() {
		ModelAndView mav = new ModelAndView();
		List<User> list = new ArrayList<User>();
//		list.add(new User("lily", 18));
//		list.add(new User("张三", 26));
		// 将所有的记录传递给返回页面
		mav.addObject("userlist", list);
		mav.setViewName("/user/users");
		return mav;
	}

}
