package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

@Controller
public class UserController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("userBean", new UserBean());
		return "Signup";
	}

	@RequestMapping(value = "/savedata", method = RequestMethod.POST)
	public String savedata(@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result, Model model) {
		model.addAttribute("userBean", userBean);

		if (result.hasErrors()) {
			if (result.getFieldError("email") != null) {
				System.out.println("email error...");
				result.rejectValue("email", "userBean.email", "An account already exists for this email.");
			}
			System.out.println(result.getAllErrors());
			return "Signup";
		} else {
			System.out.println(userBean.getEmail());
			System.out.println(userBean.getPassword());
			// dao.insert(bean)
			return "MyProfile";
		}
	}

}
