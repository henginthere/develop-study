package com.tophoon.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanFactory {
	
	@Bean
	public IMyBean myBean() {
		return new MyBean();
	}
}
