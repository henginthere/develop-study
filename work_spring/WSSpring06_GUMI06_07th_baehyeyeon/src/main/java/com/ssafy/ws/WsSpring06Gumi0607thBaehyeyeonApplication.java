package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.EtcInterceptor;
import com.ssafy.ws.interceptor.LoggingInterceptor;
import com.ssafy.ws.interceptor.UserInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.ssafy.ws.model.repo")
@EnableSwagger2
public class WsSpring06Gumi0607thBaehyeyeonApplication implements WebMvcConfigurer{
	@Autowired
	private LoggingInterceptor loggingInterceptor;
	
	@Autowired
	private EtcInterceptor etcInterceptor;
	
	@Autowired
	private UserInterceptor userInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
		registry.addInterceptor(etcInterceptor).addPathPatterns("/**");
		registry.addInterceptor(userInterceptor).addPathPatterns("/api/**");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WsSpring06Gumi0607thBaehyeyeonApplication.class, args);
	}

}
