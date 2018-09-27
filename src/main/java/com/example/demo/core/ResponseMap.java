package com.example.demo.core;

/**
 * 返回结果集
 * 
 * @author yejunxiang
 * @date 2018年9月25日
 */
public class ResponseMap {
	// 状态码
	private Integer code = 200;
	// 状态描述
	private String msg = "ok";
	// 返回结果信息
	private Object data = "";

	public static ResponseMap newInstance() {
		return new ResponseMap();
	}

	public static ResponseMap dataOf(Object data) {
		ResponseMap responseMap = new ResponseMap();
		responseMap.setData(data);
		return responseMap;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
