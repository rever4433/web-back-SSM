package com.nine.back.strategy;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.Code;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.controller.UserController;
import com.nine.back.entity.AdminResource;
import com.nine.back.entity.AdminUser;
import com.nine.back.service.MenuService;
import com.nine.back.service.UserService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class LoginStrategy  {
	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;

	 private static Logger log = Logger.getLogger(LoginStrategy.class);  

	/*
	 * Author: gaoyakang desc:登录
	 * json格式:{"username":#{username},"password":#{password},"userid":100001}
	 */

	public Object doApply(String data) {
		log.info(data);
		JSONObject jsonObject = JSONObject.parseObject(data);
		String userName = jsonObject.getString(ParamConstants.USERNAME);
		String password = jsonObject.getString(ParamConstants.PASSWORD);
		Integer userid = jsonObject.getInteger(ParamConstants.USER_ID);
		AdminUser user = userService.getAdminUserById(userid);
		JSONObject result=new JSONObject();
		if (user == null) {
		//	object.put(Code.USER_NOT_EXISTED, MsgConstants.USER_NOT_EXISTED);
			result=ResultBuildUtil.buildResult(Code.USER_NOT_EXISTED,MsgConstants.USER_NOT_EXISTED);
		} else if (password.equals(user.getPassword())) {
			String roleCode = userService.getRoleCodeByUserName(userName);
			result.put(ParamConstants.ROLE_NAME, userService.getRoleNameByRoleID(roleCode));
			JSONArray array = new JSONArray();
			List<Integer> rlist = menuService.getAllResourceIdByRoleCode(roleCode);
			for (Integer i : rlist) {
				AdminResource ar = menuService.getAdminResourceByResourceId(i);
				if (ar != null && ar.getStatus() == 1) {
					JSONObject o = new JSONObject();
					o.put(ParamConstants.ICON, ar.getIcon());
					o.put(ParamConstants.ORDER_ID, ar.getOrderid());
					o.put(ParamConstants.URL, ar.getUrl());
					o.put(ParamConstants.NAME, ar.getName());
					o.put(ParamConstants.LEAF, ar.getLeaf());
					array.add(o);
				}
			}
			
			System.out.println(userName);
			result=ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
			result.put(ParamConstants.MENU_ARRAY, array);
			result.put(ParamConstants.USERNAME, userName);
			
		} else {
			result=ResultBuildUtil.buildResult(Code.PASSWORD_INCORRECT,MsgConstants.PASSWORD_INCORRECT);
		}
		log.info(result.toJSONString());
		return result;
	}
}
