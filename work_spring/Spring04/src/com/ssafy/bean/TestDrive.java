package com.ssafy.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestDrive {
	
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("./src/com/ssafy/config/config.xml");
		Person bean1 = (Person) context.getBean("person");
		Person bean2 = context.getBean("person",Person.class);
		IPerson bean3 = context.getBean(IPerson.class);
		IPerson bean4 = context.getBean(Person.class);
		
		System.out.println(bean1==bean2); //config.xml의 scope 속성에 따라 달라짐
		
		bean1.sayHello();
		
		System.out.println(bean1);
	}

}
