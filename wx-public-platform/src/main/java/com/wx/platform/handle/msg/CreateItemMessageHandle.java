package com.wx.platform.handle.msg;

import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;

public class CreateItemMessageHandle implements MessageHandle<TextReqMsg> {
	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg("请发送IO+你的微信号方便他人联系你，例如：IOwechat");
		return tm;
	}
	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("NI")) {
			return true;
		}
		return false;
	}
}
