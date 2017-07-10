package com.nine.back.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nine.back.strategy.ChangeRoleStrategy;
import com.nine.back.strategy.LoginStrategy;
import com.nine.back.strategy.UserInfoStrategy;
import com.nine.back.strategy.UserRegisterStrategy;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private LoginStrategy loginStrategy;

	@Autowired
	private ChangeRoleStrategy changeRoleStategy;
	
	@Autowired
	private UserRegisterStrategy userRegisterStrategy;
	
	@Autowired
	private UserInfoStrategy userInfoStrategy;
	@ResponseBody
	@RequestMapping(value="/login",method = { RequestMethod.POST })
	public Object login(@RequestBody String data) throws Exception {
		System.out.println(data);
		return loginStrategy.doApply(data);
	}
	
	@ResponseBody
	@RequestMapping(value="/changerole",method = { RequestMethod.POST })
	public Object changeRole(@RequestBody String data) throws Exception {
		return changeRoleStategy.doApply(data);
	}
	
	@ResponseBody
	@RequestMapping(value="/register",method = { RequestMethod.POST })
	public Object UserRegister(@RequestBody String data) throws Exception {
		return userRegisterStrategy.doApply(data);
	}
	@ResponseBody
	@RequestMapping(value="/info",method = { RequestMethod.POST })
	public Object UserInfo(@RequestBody String data) throws Exception {
		return userInfoStrategy.doApply(data);
	}
}
