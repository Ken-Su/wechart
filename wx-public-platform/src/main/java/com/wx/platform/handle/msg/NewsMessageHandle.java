package com.wx.platform.handle.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.Article;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.NewsMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;
import com.wx.platform.util.BaseDao;

@Component
public class NewsMessageHandle implements MessageHandle<TextReqMsg> {

	@Autowired
	private BaseDao baseDao;

	private static final Logger logger = LoggerFactory
			.getLogger(NewsMessageHandle.class);

	@Override
	public BaseMsg handle(TextReqMsg message) {
		NewsMsg news = new NewsMsg();
		TextMsg tm = new TextMsg();
		Article article = new Article();
		if (message.getContent().toUpperCase().contains("NEWS")) {
			article.setDescription("Testing");
			article.setTitle("NEW People");
			news.add(article);

			return news;
		} else {
			tm.setContent("请重试");
			return tm;
		}

	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().toUpperCase().contains("NEWS")) {
			return true;
		}
		return false;
	}

}
