package com.wx.platform.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wx.platform.config.MediaTypes;
import com.wx.platform.handle.msg.CreateGroupMessageHandle;
import com.wx.platform.util.BaseDao;

@RestController
@RequestMapping(value = "/")
public class TestController {
	@Autowired
	private BaseDao baseDao;

	private static final Logger logger = LoggerFactory.getLogger(CreateGroupMessageHandle.class);

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("1111111111111111"+baseDao.getDataSource().toString());
		baseDao.commonUpdate("insert into ITEM values(?, ?)", "Hello", "Hi");
		result.put("example", "hello");
		return result;
	}
}
