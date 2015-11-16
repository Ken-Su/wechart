package com.wx.platform.handle.msg;

import org.springframework.jdbc.core.JdbcTemplate;

import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;
import com.wx.platform.util.BaseDao;

public class CreateItemMessageHandle implements MessageHandle<TextReqMsg> {
	private String itemDesc;
	private String itemOwnr;

	@Override
	public BaseMsg handle(TextReqMsg message) {
		if (message.getContent().contains("NI")) {
			this.itemDesc=message.getContent();
			TextMsg tm = new TextMsg("请发送IO+你的微信号方便他人联系你，例如：IOwechat");
			return tm;
		} else if (message.getContent().contains("IO")) {
			this.itemOwnr=message.getContent();
			BaseDao baseDao=new BaseDao(null);
			baseDao.commonUpdate("insert into ITEM values(?, ?)", this.itemDesc, this.itemOwnr);
			TextMsg tm = new TextMsg("發佈成功！");
			return tm;
		}else return new TextMsg("请重试");
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("NI") || message.getContent().contains("IO")) {
			return true;
		}
		return false;
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
