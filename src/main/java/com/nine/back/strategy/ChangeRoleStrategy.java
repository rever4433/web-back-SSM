package com.nine.back.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.entity.AdminRole;
import com.nine.back.service.UserService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class ChangeRoleStrategy {
	@Autowired
	private UserService userService;
	
	public Object doApply(String data){
		JSONObject jsonObject=JSONObject.parseObject(data);
		String userName=jsonObject.getString(ParamConstants.USERNAME);
		String roleName=jsonObject.getString(ParamConstants.ROLE_NAME);
		AdminRole role=userService.getAdminRoleByRoleName(roleName);
		JSONObject result=null;
		if(role==null){
			result=ResultBuildUtil.buildFailResult(MsgConstants.FAILED);
		}else{
			userService.changeRoleCodeByUserName(role.getRolecode(), userName);
			result=ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
		}
		return result;
	}
}
