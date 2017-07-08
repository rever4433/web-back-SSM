package com.nine.back.util;

import com.alibaba.fastjson.JSONObject;
import com.nine.back.common.Code;
import com.nine.back.common.ParamConstants;

public final class ResultBuildUtil {
	public static JSONObject buildResult(String code, String desc) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(ParamConstants.CODE, code);
		jsonObject.put(ParamConstants.DESC, desc);
		return jsonObject;
	}
	
	public static JSONObject buildSuccessResult(String desc){
		return buildResult(Code.SUCCESS, desc);
	}
	
	public static JSONObject buildFailResult(String desc){
		return buildResult(Code.FAILED, desc);
	}
	
}
