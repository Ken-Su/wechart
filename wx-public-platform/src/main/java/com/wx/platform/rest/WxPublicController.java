package com.wx.platform.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wx.platform.config.CommonConfig;
import com.wx.platform.config.MediaTypes;
import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.MessageHandle;
import com.wx.platform.handle.event.CreateGroupEventHandle;
import com.wx.platform.handle.event.CreateItemEventHandle;
import com.wx.platform.handle.event.GroupQrCodeEventHandle;
import com.wx.platform.handle.event.ScanCodeEventHandle;
import com.wx.platform.handle.event.SearchGroupEventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.handle.msg.CreateGroupMessageHandle;
import com.wx.platform.handle.msg.CreateItemMessageHandle;
import com.wx.platform.handle.msg.GroupIntroMessageHandle;
import com.wx.platform.util.BaseDao;

@RestController
@RequestMapping(value = "/")
public class WxPublicController extends WeixinControllerSupport {

	private static final String TOKEN = CommonConfig.TOKEN;
	private static final String APPID = null;
	private static final String AESKEY = null;
	
	@Autowired
	private BaseDao baseDao;

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("example", "hello");
		return result;
	}

	@Override
	protected List<MessageHandle> initMessageHandles() {
		List<MessageHandle> handles = new ArrayList<MessageHandle>();
		handles.add(new CreateGroupMessageHandle());
		handles.add(new GroupIntroMessageHandle());
		handles.add(new ChatMessageHandle());
		handles.add(new CreateItemMessageHandle(baseDao));
		return handles;
	}

	@Override
	protected List<EventHandle> initEventHandles() {
		List<EventHandle> handles = new ArrayList<EventHandle>();
		handles.add(new CreateGroupEventHandle());
		handles.add(new SearchGroupEventHandle());
		handles.add(new GroupQrCodeEventHandle());
		handles.add(new ScanCodeEventHandle());
		handles.add(new CreateItemEventHandle());
		return handles;
	}

	@Override
	protected String getToken() {
		return TOKEN;
	}

	@Override
	protected String getAppId() {
		return APPID;
	}

	@Override
	protected String getAESKey() {
		return AESKEY;
	}

}
