package com.wx.platform.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.MenuEvent;

public class CreateItemEventHandle implements EventHandle<MenuEvent> {
	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);
	@Override
	public BaseMsg handle(MenuEvent event) {
		TextMsg tm = new TextMsg("请发送NI+物品信息，例如：NI我有一只小毛炉我从来也不骑");
		return tm;
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		logger.info(event.getEventKey());
		if (event.getEventKey().equals("create_item")){
			logger.info("create_item");
			return true;
		}
		else
			return false;
	}

}
