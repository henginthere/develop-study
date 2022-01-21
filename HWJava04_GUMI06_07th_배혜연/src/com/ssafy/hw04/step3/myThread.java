package com.ssafy.hw04.step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class myThread implements Runnable{
	
	public myThread() {}

	@Override
	public void run() {
		System.out.println("스레드 실행");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("product.dat");
			//fis = new FileInputStream("product_.dat");
			ois = new ObjectInputStream(fis);

			ArrayList<Object> tmp = new ArrayList<>();
		
			tmp=(ArrayList<Object>) ois.readObject();

			System.out.println("****************************불러온 상품 전체 목록****************************");
			for(Object o:tmp) {
				System.out.println(o);
			}
		
		}
		catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("****************************불러온 상품 전체 목록****************************");
			System.out.println("등록된 상품이 없습니다.");
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
			}catch (NullPointerException e) {
				
			}
		}
	}
	
	
}
