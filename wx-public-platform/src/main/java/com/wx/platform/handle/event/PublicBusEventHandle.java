package com.wx.platform.handle.event;

import org.springframework.stereotype.Component;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.MenuEvent;

@Component
public class PublicBusEventHandle implements EventHandle<MenuEvent> {

	@Override
	public BaseMsg handle(MenuEvent event) {
		TextMsg tm = new TextMsg();
		tm.setContent("请发送'bus-几路公交-站名'来进行搜索，例如：bus-k2-南方软件园");
		return tm;
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		if (event.getEventKey().equals("public_bus")){
			return true;
		}
		else{
			return false;
		}
	}

}
