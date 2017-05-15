package com.nine.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nine.back.strategy.AddRoleStrategy;
import com.nine.back.strategy.ChangeRoleNameStrategy;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private ChangeRoleNameStrategy changeRoleNameStrategy;
	
	@Autowired
	private AddRoleStrategy addRoleStrategy;
	
	
	@ResponseBody
	@RequestMapping(value="/changerolename",method = { RequestMethod.POST })
	public Object changeRoleName(@RequestBody String data) throws Exception {
		return changeRoleNameStrategy.doApply(data);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/addrole",method = { RequestMethod.POST })
	public Object addRole(@RequestBody String data) throws Exception {
		return addRoleStrategy.doApply(data);
	}
}
