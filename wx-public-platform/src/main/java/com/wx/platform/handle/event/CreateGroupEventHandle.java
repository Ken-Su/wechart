package com.wx.platform.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.MenuEvent;

public class CreateGroupEventHandle implements EventHandle<MenuEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);

	@Override
	public BaseMsg handle(MenuEvent event) {
		TextMsg tm = new TextMsg("请发送NG+群名来创建群，例如：NG群一号");
		return tm;
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		logger.info(event.getEventKey());
		if (event.getEventKey().equals("create_group")){
			logger.info("create_group");
			return true;
		}
		else
			return false;
	}

}
