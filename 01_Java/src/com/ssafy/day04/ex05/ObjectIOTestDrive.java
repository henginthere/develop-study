package com.ssafy.day04.ex05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ObjectIOTestDrive {

	public static void main(String[] args) {

		Person p1 = new Person("홍길동", "서울", 30);
		Person p2 = new Person("홍길순", "부산", 28);
		Person p3 = new Person("홍길자", "전주", 35);

		// 1. 객체정보를 파일에 저장한다 : person.dat
		FileOutputStream fos = null;  //NS
		ObjectOutputStream oos = null; //PS
		try {
			fos = new FileOutputStream("person.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(p1); //저장하고 싶은 객체 파일에 쓰기
			oos.writeObject(p2);
			oos.writeObject(p3);
			oos.writeObject(null); //객체 다 불러왔는지 확인하기 위해
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("객체 정보를 파일에 저장완료 했습니다...");

		// 2. 저장된 파일에서 객체 정보를 읽어와서 화면에 출력한다.
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("person.dat");
			ois = new ObjectInputStream(fis);

			Object p = null;
			while ((p = ois.readObject()) != null) {
				System.out.println(p);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
