package com.wx.platform.handle.msg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wx.platform.api.MenuAPI;
import com.wx.platform.api.config.ApiConfig;
import com.wx.platform.api.entity.Menu;
import com.wx.platform.api.entity.MenuButton;
import com.wx.platform.api.enums.MenuType;
import com.wx.platform.config.CommonConfig;
import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;
import com.wx.platform.util.BaseDao;

public class ChatMessageHandle implements MessageHandle<TextReqMsg> {

	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);
	
	@Autowired
	private BaseDao<Menu> baseDao;	//作为例子， Menu是实际情况的bean

	@Override
	public BaseMsg handle(TextReqMsg message) {
		logger.info("init  menu");
		ApiConfig config = new ApiConfig(CommonConfig.APPID, CommonConfig.SECRET);
		MenuAPI menuAPI = new MenuAPI(config);
		Menu menu = new Menu();

		MenuButton button = new MenuButton();
		button.setType(MenuType.CLICK);
		button.setName("GroupChat");
		button.setKey("groupchat");

		List<MenuButton> buttonList = new ArrayList<MenuButton>();
		buttonList.add(button);

		menu.setButton(buttonList);
		menuAPI.createMenu(menu);
		
		//baseDao.update("insert into T_MENU values(:xx1, :xx2, :xx2)", new Menu());	//看注释
		//baseDao.commonUpdate(insert into T_MENU values(?, ?, ?), xx1, xx2, xx3);
		//baseDao.getJavaBean("select * from T_MENU where id=? and version=?", Menu.class, id, version);
		//baseDao.getList("select * from T_MENU where id=? and version=?", Menu.class, id, version);

		TextMsg tm = new TextMsg("init menu success");
		return tm;
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if ("159".equals(message.getContent())) {
			return true;
		}
		return false;
	}

}
