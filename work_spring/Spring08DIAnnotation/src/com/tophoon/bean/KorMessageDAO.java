package com.tophoon.bean;

import org.springframework.stereotype.Component;

@Component("korDao")
public class KorMessageDAO implements IMessageDAO {

	@Override
	public String getMessage() {
		return "안녕하세요? 반갑습니다.";
	}

}
