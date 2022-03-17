package com.tophoon.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tophoon.bean.IMyBean;
import com.tophoon.bean.MyBeanFactory;

public class TestDrive {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanFactory.class);

		IMyBean bean = context.getBean("myBean", IMyBean.class);
		bean.sayHello();
	}

}
