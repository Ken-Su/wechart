package com.wx.platform.handle.event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wx.platform.entity.Item;
import com.wx.platform.handle.EventHandle;
import com.wx.platform.handle.msg.ChatMessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.MenuEvent;
import com.wx.platform.util.BaseDao;

public class ItemEventHandle implements EventHandle<MenuEvent> {
	private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandle.class);
	private BaseDao baseDao;
	public ItemEventHandle(BaseDao baseDao) {
		super();
		this.baseDao = baseDao;
	}

	@Override
	public BaseMsg handle(MenuEvent event) {
		TextMsg tm = new TextMsg();
		if(event.getEventKey().equals("create_item")){
			return tm;
		}else if (event.getEventKey().equals("search_item")){
			tm.setContent("请发送SI+物品信息来进行搜索，例如：SI变形金刚");
			return tm;
		}else if(event.getEventKey().equals("my_item")) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			List<Item> itemList=baseDao.getList("select * from item where userid=?", Item.class,event.getFromUserName());
			if(itemList.size()==0){
				tm.setContent("你还没有发布");
				return tm;
			}
			String content="";
			for(int i=0;i<itemList.size();i++){
				content+="编号："+itemList.get(i).getId()+"\n";
				content+="物品："+itemList.get(i).getItemDesc()+"\n";
				content+="发布时间："+format.format(itemList.get(i).getCrtDt())+"\n";
			}
			tm.setContent(content);
			return tm;
		}else if (event.getEventKey().equals("delete_item")){
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			List<Item> itemList=baseDao.getList("select * from item where userid=?", Item.class,event.getFromUserName());
			if(itemList.size()==0){
				tm.setContent("你还没有发布");
				return tm;
			}
			String content="";
			for(int i=0;i<itemList.size();i++){
				content+="编号："+itemList.get(i).getId()+"\n";
				content+="物品："+itemList.get(i).getItemDesc()+"\n";
				content+="发布时间："+format.format(itemList.get(i).getCrtDt())+"\n";
			}
			tm.setContent(content+"请发送DI+物品编号来删除你的闲置，例如DI1");
			return tm;
		}else{
			tm.setContent("请重试！");
			return tm;
		}
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		if (event.getEventKey().equals("create_item")||event.getEventKey().equals("search_item")||event.getEventKey().equals("my_item")||event.getEventKey().equals("delete_item")){
			return true;
		}
		else
			return false;
	}

}
