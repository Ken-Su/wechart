package com.wx.platform.entity;

import java.util.Date;

public class Item {
	private String id;
	private String itemDesc;
	private String itemOwnr;
	private String userId;
	private Date crtDt;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Date getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(Date crtDt) {
		this.crtDt = crtDt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemOwnr() {
		return itemOwnr;
	}

	public void setItemOwnr(String itemOwnr) {
		this.itemOwnr = itemOwnr;
	}
}
