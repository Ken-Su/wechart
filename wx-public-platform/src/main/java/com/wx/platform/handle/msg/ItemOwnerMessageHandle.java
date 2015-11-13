package com.wx.platform.handle.msg;

import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;

public class ItemOwnerMessageHandle implements MessageHandle<TextReqMsg> {
	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg("发布成功啦！");
		return tm;
	}
	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("IO")) {
			return true;
		}
		return false;
	}
}
