package com.wx.platform.handle.msg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wx.platform.entity.Item;
import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.TextMsg;
import com.wx.platform.message.req.TextReqMsg;
import com.wx.platform.util.BaseDao;

@Component
public class ItemMessageHandle implements MessageHandle<TextReqMsg> {

	@Autowired
	private BaseDao baseDao;

	private static final Logger logger = LoggerFactory.getLogger(ItemMessageHandle.class);
	/*
	 * public ItemMessageHandle(BaseDao baseDao) { super(); this.baseDao =
	 * baseDao; }
	 */

	@Override
	public BaseMsg handle(TextReqMsg message) {
		TextMsg tm = new TextMsg();

		if (message.getContent().toUpperCase().contains("NI") && message.getContent().length() > 2) {
			Item item = new Item();
			String[] content = message.getContent().substring(2).split(" ");
			item.setItemDesc(content[0]);
			item.setItemOwnr(content[1]);
			item.setUserId(message.getFromUserName());
			item.setCrtDt(new Date(System.currentTimeMillis()));
			baseDao.commonUpdate("insert into ITEM (itemdesc,itemownr,userid,crt_dt) values(?, ?,?,?)",
					item.getItemDesc(), item.getItemOwnr(), item.getUserId(), item.getCrtDt());
			tm.setContent("发布成功！");
			return tm;
		} else if (message.getContent().toUpperCase().contains("SI") && message.getContent().length() > 2) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			List<Item> i = baseDao.getList("select * from ITEM where itemdesc LIKE ?", Item.class,
					"%" + message.getContent().substring(2) + "%");
			if (i.size() == 0) {
				tm.setContent("没有这种物品");
				return tm;
			}
			String content = "";
			for (int j = 0; j < i.size(); j++) {
				content += "物品：" + i.get(j).getItemDesc() + "\n";
				content += "用户：" + i.get(j).getItemOwnr() + "\n";
				content += "发布时间" + format.format(i.get(j).getCrtDt()) + "\n\n";
			}
			tm.setContent(content);
			return tm;
		} else if (message.getContent().toUpperCase().contains("DI") && message.getContent().length() > 2) {
			if (baseDao.commonUpdate("delete from item where id=? and userid=?", message.getContent().substring(2),
					message.getFromUserName()) != 0)
				tm.setContent("删除成功");
			else
				tm.setContent("刪除失败");
			return tm;
		} else {
			tm.setContent("请重试");
			return tm;
		}
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		if (message.getContent().toUpperCase().contains("NI") || message.getContent().toUpperCase().contains("IO")
				|| message.getContent().toUpperCase().contains("SI")
				|| message.getContent().toUpperCase().contains("DI")) {
			return true;
		}
		return false;
	}

}
