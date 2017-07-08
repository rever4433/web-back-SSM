package com.nine.back.strategy;

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
public class UserRegisterStrategy {
	@Autowired
	private UserService userService;

	private static Logger logger = Logger.getLogger(UserRegisterStrategy.class);

	public Object doApply(String data) throws Exception {
		JSONObject jsonObject = JSONObject.parseObject(data);
		String userName = jsonObject.getString(ParamConstants.USERNAME);
		String password = jsonObject.getString(ParamConstants.PASSWORD);
		String realName = jsonObject.getString(ParamConstants.REAL_NAME);
		// Integer retry=jsonObject.getInteger(ParamConstants.RETRY);
		// Integer status=jsonObject.getInteger(ParamConstants.STATUS);
		String roleCode = jsonObject.getString(ParamConstants.ROLE_CODE);
		JSONObject result = null;
		Integer userId = userService.getUserIdByUserName(userName);
		if (userService.UserIsExisted(userId)) {
			result = ResultBuildUtil.buildFailResult(MsgConstants.USER_IS_EXISTED);
			logger.error("用户ID："+userId+" 已经存在");
		} else if (password.length() < 6 || password.length() > 22) {
			result = ResultBuildUtil.buildFailResult(MsgConstants.PASSWORD_LENGTH_INCORRECT);
		} else {
			Date now = new Date();
			AdminUser user = new AdminUser();
			user.setUsername(userName);
			user.setCreatedate(now.getTime());
			user.setLastdate(now.getTime());
			user.setPassword(password);
			user.setRetry((short) 3);
			user.setStatus(1);
			user.setRolecode(roleCode);
			user.setRealname(realName);
			userService.insertAdminUser(user);
			result = ResultBuildUtil.buildSuccessResult(MsgConstants.SUCCESS);
		}

		return result;
	}
}
