package com.nine.back.strategy;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.entity.AdminRole;
import com.nine.back.entity.AdminUser;
import com.nine.back.service.MenuService;
import com.nine.back.service.RoleManageService;
import com.nine.back.service.UserService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class ShowAllRoleStrategy {
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleManageService roleManageService;
	
	@Autowired
	private UserService userService;
	private static Logger log = Logger.getLogger(ShowAllRoleStrategy.class);  
	/*
	 * username userid password
	 */
	public Object doApply(String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String userName=jsonObject.getString(ParamConstants.USERNAME);
		String password=jsonObject.getString(ParamConstants.PASSWORD);
		Integer userId=jsonObject.getInteger(ParamConstants.USER_ID);
		log.info(data);
		JSONObject result=new JSONObject();
		AdminUser user=userService.getAdminUserById(userId);
		if(user!=null&&user.getPassword().equals(password)&&user.getUsername().equals(userName)){
			List<AdminRole> list=roleManageService.getAllAdminRole();
			
			JSONArray array=new JSONArray();
			for(AdminRole ar:list){
				array.add(ar);
			}
			result=ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
			result.put("rolenames", array);
		}else{
			result=ResultBuildUtil.buildFailResult(MsgConstants.FAILED);
		}
		log.info(result);
		return result;
	}
}
