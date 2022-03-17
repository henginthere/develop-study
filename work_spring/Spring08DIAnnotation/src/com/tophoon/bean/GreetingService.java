package com.tophoon.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("greeting")
/*
 * @Scope Annotation
 *
 * 범위 				설명
 * singleton		스프링 컨테이너에 한 개의 빈 객체만 존재한다. (기본값)
 * prototype		빈을 사용할 때 마다 객체를 생성한다.
 * request			HTTP 요청마다 빈 객체를 생성한다. WebApplicationContext에서만 적용 가능하다.
 * session			HTTP 세션마다 빈 객체를 생성한다. WebApplicationContext에서만 적용 가능하다.
 * global-session	글로벌 HTTP 세션에 대해 빈 객체를 생성한다. 포틀릿을 지원하는 컨텍스트에 대해서만 적용 가능하다.
 */
@Scope("singleton")
public class GreetingService {

	@Autowired
	@Qualifier("engDao")
	private IMessageDAO dao;

	public GreetingService() {}

	/*@Autowired*/
	public GreetingService(/*@Qualifier("korDao") */IMessageDAO dao) {
		this.dao = dao;
	}

	/*@Autowired*/
	public void setDao(/*@Qualifier("korDao") */IMessageDAO dao) {
		this.dao = dao;
	}

	public void sayHello() {
		System.out.println(dao.getMessage());
	}
}
