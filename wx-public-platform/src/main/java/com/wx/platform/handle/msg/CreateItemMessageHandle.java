package com.wx.platform.handle.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wx.platform.entity.Item;
import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;
import com.wx.platform.util.BaseDao;

public class CreateItemMessageHandle implements MessageHandle<TextReqMsg> {
	private static final Logger logger = LoggerFactory.getLogger(CreateGroupMessageHandle.class);

	@Autowired
	private BaseDao baseDao;

	private Item item = new Item();

	@Override
	public BaseMsg handle(TextReqMsg message) {
		if (message.getContent().contains("NI")) {
			item.setItemDesc(message.getContent());
			TextMsg tm = new TextMsg("请发送IO+你的微信号方便他人联系你，例如：IOwechat");
			return tm;
		} else if (message.getContent().contains("IO")) {
			item.setItemOwnr(message.getContent());
			logger.info(item.getItemDesc());
			logger.info(item.getItemOwnr());
			baseDao.commonUpdate("insert into ITEM values(?, ?)", item.getItemDesc(), item.getItemOwnr());
			TextMsg tm = new TextMsg("發佈成功！");
			return tm;
		} else
			return new TextMsg("请重试");
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("NI") || message.getContent().contains("IO")) {
			return true;
		}
		return false;
	}

}
