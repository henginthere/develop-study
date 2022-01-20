package com.ssafy.day04.q02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.ssafy.day04.q02.Book;

public class ListObjectIOTest {

	
	public static void main(String[] args) {
		
		//1. 책 객체를 3개 생성
		Book b1 = new Book("어린왕자", "생텍쥐페리",12000);
		Book b2 = new Book("나의 라임 오렌지나무", "바스콘셀로스", 11700);
		Book b3 = new Book("아몬드", "손원평",10000);
		
		//2. 1번에서 만든 객체를 ArrayList에 담기
		ArrayList<Object> books = new ArrayList<>();
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		//3. 2번에서 만든 ArrayList 객체를 파일에 저장 (ObjectIOTestDrive 예제 참고)
		// book_data.dat
		FileOutputStream fos = null;  //NS
		ObjectOutputStream oos = null; //PS
		try {
			fos = new FileOutputStream("book_data.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(books);
			oos.writeObject(null);
			
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
		System.out.println("객체 정보를 파일에 저장 완료.");
		
		//4. 저장된 파일에서 객체 정보를 읽어오기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("book_data.dat");
			ois = new ObjectInputStream(fis);

		//5. System.out.println 메서드를 이용해서 리스트 출력
			Object p = null;
			ArrayList<Object> tmp =(ArrayList<Object>)ois.readObject();
			for(Object o:tmp) {
				System.out.println(o);
			}
			//System.out.println(tmp);
//
//			while ((p = ois.readObject()) != null) {
//				System.out.println(p);
//			}
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
		
		
		//6. 파일 입출력 관련 변수들 close() 호출하여 정리
	}
	

