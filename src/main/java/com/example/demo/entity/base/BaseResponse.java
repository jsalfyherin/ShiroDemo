package com.example.demo.entity.base;

import java.util.Map;

public class BaseResponse {

	public String respCode;
	public String respMsg;
	public Map dataMap;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public Map getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}
	
	public void setResPonseData(String respCode,String respMsg,Map dataMap){
		this.respCode = respCode;
		this.respMsg = respMsg;
		this.dataMap = dataMap;
	}

	
}
