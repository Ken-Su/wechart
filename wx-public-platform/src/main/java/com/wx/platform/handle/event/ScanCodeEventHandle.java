package com.wx.platform.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.req.ScanCodeEvent;

@Component
public class ScanCodeEventHandle implements EventHandle<ScanCodeEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);
	
	@Override
	public BaseMsg handle(ScanCodeEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(ScanCodeEvent event) {
		logger.info(event.getEvent());
		logger.info(event.getEventKey());
		logger.info(event.getMsgType());
		logger.info(event.getScanResult());
		logger.info(event.getScanType());
		return false;
	}

}
