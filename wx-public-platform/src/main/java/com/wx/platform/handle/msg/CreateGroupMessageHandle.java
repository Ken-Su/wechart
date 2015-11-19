package com.wx.platform.handle.msg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wx.platform.api.MenuAPI;
import com.wx.platform.api.config.ApiConfig;
import com.wx.platform.api.entity.Menu;
import com.wx.platform.api.entity.MenuButton;
import com.wx.platform.api.enums.MenuType;
import com.wx.platform.config.CommonConfig;
import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.EventType;
import com.wx.platform.message.req.TextReqMsg;

@Component
public class CreateGroupMessageHandle implements MessageHandle<TextReqMsg> {

	private static final Logger logger = LoggerFactory.getLogger(CreateGroupMessageHandle.class);

	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg("请填写群介绍JS+介绍，例：JS大家好");
		return tm;
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("NG")) {
			return true;
		}
		return false;
	}

}
