package com.green;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author limingliang
 * @version 2018年10月10日 下午3:37:09 
 */
@SpringBootApplication
public class WebApplication {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		new SpringApplicationBuilder(WebApplication.class).web(true).run(args);
	}
}
