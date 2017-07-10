package com.nine.back.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.MsgConstants;
import com.nine.back.common.ParamConstants;
import com.nine.back.entity.AdminUser;
import com.nine.back.service.UserService;
import com.nine.back.util.ResultBuildUtil;

@Component
public class UserInfoStrategy {
	@Autowired 
	private UserService userService;
	private static Logger log = Logger.getLogger(UserInfoStrategy.class);  
	public Object doApply(String data) {
		log.info(data);
		JSONObject jsonObject = JSONObject.parseObject(data);
		String userName = jsonObject.getString(ParamConstants.USERNAME);
		String password = jsonObject.getString(ParamConstants.PASSWORD);
		Integer userid = jsonObject.getInteger(ParamConstants.USER_ID);
		AdminUser user = userService.getAdminUserById(userid);
		JSONObject result=new JSONObject();
		if(user!=null&&password.equals(user.getPassword())){
			result.put(ParamConstants.USERNAME, userName);
			result.put(ParamConstants.REAL_NAME, user.getRealname());
			result.put(ParamConstants.CREATE_TIME, transferLongToDate("yyyy-MM-dd HH:mm:ss",user.getCreatedate()));
			result.put(ParamConstants.LAST_TIME, transferLongToDate("yyyy-MM-dd HH:mm:ss",user.getLastdate()));
			result.put(ParamConstants.STATUS, user.getStatus());
		}else{
			result=ResultBuildUtil.buildFailResult(MsgConstants.USER_NOT_EXISTED);
		}
		log.info(result);
		return result;
		
	}
	 public String transferLongToDate(String dateFormat, Long millSec) {
		          SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		          Date date = new Date(millSec);
		          return sdf.format(date);
		      }
}
