package com.wx.platform.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wx.platform.api.MenuAPI;
import com.wx.platform.api.config.ApiConfig;
import com.wx.platform.api.entity.Menu;
import com.wx.platform.api.enums.ResultType;
import com.wx.platform.api.response.GetMenuResponse;
import com.wx.platform.config.CommonConfig;
import com.wx.platform.config.MediaTypes;

@RestController
@RequestMapping(value = "/menu")
public class MenuRestController {
	
	private MenuAPI menuAPI = new MenuAPI(new ApiConfig(CommonConfig.APPID, CommonConfig.SECRET));
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Menu getMenu(){
		GetMenuResponse  getMenuResponse = menuAPI.getMenu();
		return getMenuResponse.getMenu();
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, consumes = MediaTypes.JSON)
	public Menu createMenu(@RequestBody Menu menu){
		ResultType resultType = menuAPI.createMenu(menu);
		if(resultType.getCode() == ResultType.SUCCESS.getCode()){
			return menu;
		}
		return null;
	}
}
