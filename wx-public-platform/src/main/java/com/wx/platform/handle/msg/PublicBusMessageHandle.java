package com.wx.platform.handle.msg;

import org.springframework.stereotype.Component;

import com.wx.platform.api.PublicBusAPI;
import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;

@Component
public class PublicBusMessageHandle implements MessageHandle<TextReqMsg> {

	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg();
		String[] requestResult = message.getContent().split("-");
		if(requestResult.length != 3){
			tm.setContent("亲，没找到对应结果，再来一次吧，么么哒");
		}else{
			String content = PublicBusAPI.getNextBus(requestResult[1], requestResult[2]);
			tm.setContent(content);
		}
		return tm;
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().toUpperCase().contains("BUS")) {
			return true;
		}
		return false;
	}

}
