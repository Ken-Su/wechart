package com.wx.platform.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.req.MenuEvent;

@Component
public class SearchGroupEventHandle implements EventHandle<MenuEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);

	@Override
	public BaseMsg handle(MenuEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		if (event.getEventKey() == "search_group"){
			logger.info("search_group");
			return true;
		}
		
		else
			return false;
	}

}
