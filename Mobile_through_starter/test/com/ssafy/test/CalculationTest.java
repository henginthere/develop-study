package com.ssafy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class CalculationTest {

	CalculationService service = new CalculationServiceImpl();

	
	@Test
    @Order(1)
	void 정수범위테스트() {
		int result = service.add(100, 100);
		assertEquals(200 , result);
	}

	@Test
    @Order(2)
	void 마이너스테스트() {
		int result = service.add(100, -100);
		assertEquals(0 , result);
	}
}
