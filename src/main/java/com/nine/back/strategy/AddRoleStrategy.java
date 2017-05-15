package com.nine.back.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.service.RoleManageService;
import com.nine.back.service.UserService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class AddRoleStrategy {
	@Autowired
	private RoleManageService roleManagerService;
	
	@Autowired
	private UserService userService;
	
	public Object doApply(String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String roleName=jsonObject.getString(ParamConstants.ROLE_NAME);
		String roleCode=userService.getRoleCodeByUserName(ParamConstants.ROLE_CODE);
		JSONObject result=null;
		if(!roleManagerService.roleCodeExisted(roleCode)){
			roleManagerService.AddAdminRole(roleCode, roleName);
			result=ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
		}else {
			result=ResultBuildUtil.buildFailResult(MsgConstants.ROLE_IS_EXISTED);
		}
		
		return result;
	}
}
