package com.ssafy.ws04.step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class myThread implements Runnable{


	public myThread() {
		
	}

	@Override
	public void run() {
		
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			System.out.println("스레드실행");
			try {
				fis = new FileInputStream("book.dat");
				//fis = new FileInputStream("book_.dat");
				ois = new ObjectInputStream(fis);

				ArrayList<Object> tmp = new ArrayList<>();
			
				tmp=(ArrayList<Object>) ois.readObject();

				System.out.println("****************************불러온 도서 전체 목록****************************");
				for(Object o:tmp) {
					System.out.println(o);
				}
			
			}
			
			catch (FileNotFoundException e) {
				//e.printStackTrace();
				System.out.println("****************************불러온 도서 전체 목록****************************");
				System.out.println("등록된 도서가 없습니다.");
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
//			catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			
		}
	
}
