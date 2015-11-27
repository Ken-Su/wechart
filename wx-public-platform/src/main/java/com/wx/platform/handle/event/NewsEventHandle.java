package com.wx.platform.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wx.platform.handle.EventHandle;
import com.wx.platform.message.Article;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.NewsMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.MenuEvent;
import com.wx.platform.util.BaseDao;

@Component
public class NewsEventHandle implements EventHandle<MenuEvent> {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsEventHandle.class);
	
	@Autowired
	private BaseDao baseDao;
	
	/*public ItemEventHandle(BaseDao baseDao) {
		super();
		this.baseDao = baseDao;
	}*/

	@Override
	public BaseMsg handle(MenuEvent event) {
		NewsMsg news = new NewsMsg();
		Article article = new Article();
		TextMsg tm = new TextMsg();
		if(event.getEventKey().equals("new_fellow")){
//			tm.setContent("请重试！");
			article.setDescription("Testing");
			article.setTitle("NEW People");
			news.add(article);
			return news;
		}else{
			tm.setContent("请重试！");
			return tm;
		}
	}

	@Override
	public boolean beforeHandle(MenuEvent event) {
		if (event.getEventKey().equals("new_fellow")){
			return true;
		}
		else
			return false;
	}

}
