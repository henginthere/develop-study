package com.ssafy.ws.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@PostMapping("/login")
	public String doLogin(User user, HttpSession session, Model model) {
		User loginUser = uService.select(user);
		
		if(loginUser!=null && loginUser.getId()!=null) { //데이터 베이스에 사용자가 존재하는 경우
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}
		else {
			model.addAttribute("msg", "로그인 실패");
			return "index";
		}
	}
	
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
