package com.wx.platform;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Spring Java Config的标识
@Configuration
// Spring 默认扫描ClassPath中的Component，以本类所在地package为起点。
@ComponentScan
// Spring Boot的AutoConfig
@EnableAutoConfiguration
public class WxPublicPlatformApplication {
	
	@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());	//可以用 yourserver/console url访问h2的控制台
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WxPublicPlatformApplication.class, args);
	}
}
