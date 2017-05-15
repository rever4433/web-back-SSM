package com.nine.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nine.back.strategy.AddMenuStrategy;
import com.nine.back.strategy.CloseMenuStrategy;
import com.nine.back.strategy.DeleteMenuStrategy;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private AddMenuStrategy addMenuStrategy;
	
	@Autowired
	private DeleteMenuStrategy deleteMenuStrategy;
	
	@Autowired
	private CloseMenuStrategy closeMenuStrategy;
	
	@ResponseBody
	@RequestMapping(value="/addleaf",method={RequestMethod.POST})
	public Object addLeafMenu(@RequestBody String data)throws Exception{
		return addMenuStrategy.doApply(data);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public Object deleteMenu(@RequestBody String data)throws Exception{
		return deleteMenuStrategy.doApply(data);
	}
	
	@ResponseBody
	@RequestMapping(value="/close",method={RequestMethod.POST})
	public Object closeMenu(@RequestBody String data)throws Exception{
		return closeMenuStrategy.doApply(data);
	}
}
