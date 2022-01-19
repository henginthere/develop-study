package com.ssafy.day03.collection.generics.wild;

public class WildTypeTest {
	public void wildCardTest() {
		PersonBox<Object> pObj = new PersonBox<>();
		PersonBox<Person> pPer = new PersonBox<>();
		PersonBox<SpiderMan> pSpi = new PersonBox<>();

		// 어떤 타입이 오던지 다 받아줄 수 있다.
		PersonBox<?> pAll = pPer;
		pAll = pSpi;
		pAll = pObj;

		// Person 또는 상속받은 경우만 받아줄 수 있다.
		PersonBox<? extends Person> pChildPer = pPer;
		pChildPer = pSpi;
		// pChildPer = pObj;

		// Person 또는 조상만 받아줄 수 있다.
		PersonBox<? super Person> pSuperPer = pPer;
		// pSuperPer = pSpi;
		pSuperPer = pObj;
	}
}



class Person {
}


class SpiderMan extends Person {
}


class PersonBox<T> {
}