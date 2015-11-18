package com.wx.platform.handle.msg;

import java.util.List;

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
	

	private BaseDao baseDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateItemMessageHandle.class);
	public CreateItemMessageHandle(BaseDao baseDao) {
		super();
		this.baseDao = baseDao;
	}

	private Item item = new Item();

	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg();
		if (message.getContent().contains("NI")) {
			item.setItemDesc(message.getContent().substring(2));
			tm.setContent("请发送IO+你的微信号方便他人联系你，例如：IOwechat");
			return tm;
		} else if (message.getContent().contains("IO")) {
			if(item.getItemDesc()==null){
				tm.setContent("请重试");
				return tm;
			}
			item.setItemOwnr(message.getContent().substring(2));
			baseDao.commonUpdate("insert into ITEM values(?, ?)", item.getItemDesc(), item.getItemOwnr());
			tm.setContent("发布成功！");
			return tm;
		} else if(message.getContent().contains("SI")){
			List<Item> i = baseDao.getList("select * from ITEM where itemdesc LIKE ?", Item.class,"%"+message.getContent().substring(2)+"%");
			String content = "";
			for(int j=0;j<i.size();j++){
				content+="物品："+i.get(j).getItemDesc()+"\n";
				content+="用户："+i.get(j).getItemOwnr()+"\n";
			}
			tm.setContent(content);
			return tm;
		} else {
			tm.setContent("请重试");
			return tm;
		}
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().contains("NI") || message.getContent().contains("IO")||message.getContent().contains("SI")) {
			return true;
		}
		return false;
	}

}
