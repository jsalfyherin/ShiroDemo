package com.example.demo.entity.base;

public class BaseRequest {

	/**用户Id**/
	public String userId;
	/**查询分页**/
	public String page;         
	/**每页记录数**/
	public String limit;
	/**查询记录数 **/
	public String count;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
}
