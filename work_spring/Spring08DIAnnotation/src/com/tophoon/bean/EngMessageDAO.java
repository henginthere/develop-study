package com.tophoon.bean;

import org.springframework.stereotype.Component;

@Component("engDao")
public class EngMessageDAO implements IMessageDAO {

	@Override
	public String getMessage() {
		return "Hello. Nice to meet you.";
	}

}
