package com.wx.platform.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.req.MenuEvent;

public class ClickEventHandle implements EventHandle<MenuEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);

	@Override
	public BaseMsg handle(MenuEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		// TODO Auto-generated method stub
		logger.info(event.getMsgType());
		logger.info(event.getEvent());
		logger.info(event.getEventKey());

		return false;
	}

}
