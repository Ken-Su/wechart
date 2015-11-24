package com.wx.platform;

import java.util.ArrayList;
import java.util.List;

import com.wx.platform.api.MaterialAPI;
import com.wx.platform.api.config.ApiConfig;
import com.wx.platform.api.entity.Article;
import com.wx.platform.config.CommonConfig;

public class newsSupport {

	private static final String APPID = CommonConfig.APPID;
	private static final String SECRET = CommonConfig.SECRET;

	public static void main(String[] args) {
		ApiConfig apiCon = new ApiConfig(APPID, SECRET);

		MaterialAPI mp = new MaterialAPI(apiCon);
		Article article = new Article();
		article.setAuthor("Jason");
		article.setContent("Testing");
		article.setContentSourceUrl("localhost:8080");
		article.setDigest("Welcome to new fellows");
		article.setShowConverPic(0);
		article.setTitle("New fellows");
		article.setThumbMediaId("1111");
		List<Article> art = new ArrayList<Article>();
		art.add(article);
		mp.uploadMaterialNews((List<Article>) art);
		
	}

}
