package com.ssafy.day02.ex00;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTestDrive {

	public static void main(String[] args) {

		SmartDevice device = new SmartDevice("SN_001", "SP", "MyPhone");

		try {
			// Class를 가져오는 방법
			Class myClass1 = SmartDevice.class;
			Class myClass2 = device.getClass();
			Class myClass3 = Class.forName("com.ssafy.day02.ex00.SmartDevice");
			Object object3 = myClass3.newInstance();

			// Class를 통해 해당 class의 정보를 추출하자.
			Field[] fieldArray = myClass2.getDeclaredFields();
			for (Field f:fieldArray) {
				System.out.println(f.getName());
			}

			Method[] methodArray = myClass2.getDeclaredMethods();
			for (Method m:methodArray) {
				//System.out.println(m.getName());
				if (m.getName().startsWith("setDevName")) {
					m.invoke(device, "YourPhone");
				}
			}
			System.out.println(device);

			Class clazz = Class.forName("com.ssafy.day02.ex00.SmartDevice");
			Object object = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setSn", String.class);
			method.invoke(object, "SP-003");
			System.out.println(object);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
