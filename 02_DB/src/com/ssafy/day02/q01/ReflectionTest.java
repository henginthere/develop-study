package com.ssafy.day02.q01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
	private String name;
	private int age;
	
	public Person(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
public class ReflectionTest {
	
	public static void main(String[] args) throws Exception {
		
		//Reflaction을 이용해 클래스 정보 가져오기
		//이유: new 키워드 사용하지 않고 객체를 생성하기 위해서
		Class myClass1 = Person.class;
		Class myClass2 = new Person().getClass();
		Class myClass3 = Class.forName("com.ssafy.day02.q01.Person");
		
		Object object3 = myClass3.newInstance(); // 기존에 new Person 한 것과 같음
		
		Field[] fieldArray = myClass3.getDeclaredFields();
		for(Field f:fieldArray) { //field를 배열에 넣은 것
			System.out.println(f.getName());
		}
		
		Method[] methodArray = myClass3.getDeclaredMethods();
		for(Method m:methodArray) {
			if(m.getName().startsWith("setName")) {
				//new Person().setName(); 한 것과 같음
				m.invoke(new Person(), "김싸피");
			}
		}
		
	}

	
}
