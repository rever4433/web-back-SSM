package com.nine.back.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.entity.AdminRole;
import com.nine.back.service.RoleManageService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class ChangeRoleNameStrategy {

	@Autowired
	private RoleManageService roleManageService;

	public Object doApply(String data) {
		JSONObject jsonObject = JSONObject.parseObject(data);
		String roleCode = jsonObject.getString(ParamConstants.ROLE_CODE);
		String roleName = jsonObject.getString(ParamConstants.ROLE_NAME);
		AdminRole role = roleManageService.getAdminRoleByRoleCode(roleCode);
		JSONObject result = null;
		if (role == null) {
			result = ResultBuildUtil.buildFailResult(MsgConstants.FAILED);
		} else {
			roleManageService.updateRoleNameByRoleCode(roleCode, roleName);
			result = ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
		}
		return result;
	}
}
