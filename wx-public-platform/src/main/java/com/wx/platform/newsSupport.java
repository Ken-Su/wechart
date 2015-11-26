package com.wx.platform;

import java.io.File;

import com.wx.platform.api.MaterialAPI;
import com.wx.platform.api.config.ApiConfig;
import com.wx.platform.api.response.UploadMaterialResponse;
import com.wx.platform.config.CommonConfig;

public class newsSupport {

	private static final String APPID = CommonConfig.APPID;
	private static final String SECRET = CommonConfig.SECRET;

	public static void main(String[] args) {
		ApiConfig apiCon = new ApiConfig(APPID, SECRET);

		MaterialAPI mp = new MaterialAPI(apiCon);
		
		
		String pathname = "D:\\example.jpg";
		File file = new File(pathname);
		UploadMaterialResponse ur1 = mp.uploadMaterialFile(file);
		System.out.println(ur1.getMediaId());
		
//		Article article = new Article();
//		article.setAuthor("Jason");
//		article.setContent("Testing");
//		article.setContentSourceUrl("localhost:8080");
//		article.setDigest("Welcome to new fellows");
//		article.setShowConverPic(0);
//		article.setTitle("New fellows");
//		//article.setThumbMediaId("1111");
//		List<Article> art = new ArrayList<Article>();
//		art.add(article);
//		UploadMaterialResponse ur = mp.uploadMaterialNews((List<Article>) art);
//		System.out.println(ur.getMediaId());
		
	}

}
