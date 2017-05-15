package com.nine.back.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.Code;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.entity.AdminResource;
import com.nine.back.entity.AdminRoleResource;
import com.nine.back.service.MenuService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class AddMenuStrategy {
	@Autowired
	private MenuService menuService;

	/*
	 * Author: gaoyakang desc:添加菜单
	 */

	public Object doApply(String data) {
		JSONObject jsonObject = JSONObject.parseObject(data);
		String Name = jsonObject.getString(ParamConstants.NAME);
		String roleCode = jsonObject.getString(ParamConstants.ROLE_CODE);
		String url = jsonObject.getString(ParamConstants.URL);
		Integer orderId = jsonObject.getInteger(ParamConstants.ORDER_ID);
		String icon = jsonObject.getString(ParamConstants.ICON);
		String parentmenu = jsonObject.getString(ParamConstants.PARENT_MENU);
		AdminResource parent = menuService.getAdminResourceByName(parentmenu);
		Integer pid = 0;
		if (parent != null) {
			pid = parent.getRid();
		}
		Integer rid = menuService.getMaxResourceId() + 1;
		JSONObject result =null;
		AdminResource ar = new AdminResource();
		ar.setIcon(icon);
		ar.setName(Name);
		ar.setUrl(url);
		ar.setPid(pid);
		ar.setRid(rid);
		ar.setOrderid(orderId);
		AdminRoleResource arr = new AdminRoleResource();
		arr.setRolecode(roleCode);
		arr.setResourceid(rid);

		if (pid == 0) {
			// 添加父菜单
			menuService.addAdminRoleResource(arr);
			ar.setStatus(1);
			ar.setLeaf(0);
			menuService.addAdminResource(ar);
			result = ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
			result.put(ParamConstants.MENU_INFO, JSONObject.toJSON(menuService.getAdminResourceByResourceId(rid)));
		} else if (parent == null) {
			result=ResultBuildUtil.buildResult(Code.PARENTMENU_NOT_EXISTED,MsgConstants.PARENTMENU_NOT_EXISTED);
		} else if (parent.getLeaf() == 1 || parent.getStatus() == 0||!menuService.getRoleCodeByResourceId(pid).equals(roleCode)) {
			result=ResultBuildUtil.buildResult(Code.MENU_STATUS_FAULT,MsgConstants.MENU_STATUS_FAULT);
		}  else {
			menuService.addAdminRoleResource(arr);
			ar.setStatus(1);
			ar.setLeaf(1);
			menuService.addAdminResource(ar);
			result = ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
			result.put(ParamConstants.MENU_INFO, JSONObject.toJSON(menuService.getAdminResourceByResourceId(rid)));
		}
		return result;
	}

}
