package com.wx.platform.handle.msg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class GroupIntroMessageHandle implements MessageHandle<TextReqMsg> {

	private static final Logger logger = LoggerFactory.getLogger(GroupIntroMessageHandle.class);

	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg("请上传群二维码");
		return tm;
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("JS")) {
			return true;
		}
		return false;
	}

}
