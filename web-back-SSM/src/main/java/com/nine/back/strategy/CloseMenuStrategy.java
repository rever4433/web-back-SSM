package com.nine.back.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.service.MenuService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class CloseMenuStrategy {
	@Autowired
	private MenuService menuService;
	
	public Object doApply(String data){
		JSONObject jsonObject=JSONObject.parseObject(data);
		String Name=jsonObject.getString(ParamConstants.NAME);
		JSONObject result=null;
		if(menuService.closeMenu(Name)==1){
			result=ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
		}else result=ResultBuildUtil.buildFailResult(MsgConstants.FAILED);
		return result;
	}
}
