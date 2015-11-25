package com.wx.platform.handle.msg;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wx.platform.handle.MessageHandle;
import com.wx.platform.message.BaseMsg;
import com.wx.platform.message.req.TextReqMsg;
import com.wx.platform.util.BaseDao;

public class PublicStationMessageHandle implements MessageHandle<TextReqMsg> {
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public BaseMsg handle(TextReqMsg message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(TextReqMsg message) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<Map<String, Object>> getStationRouteList(String fromStation, String toStation){
		return null;
	}

}
