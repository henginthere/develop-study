package com.ssafy.day02.ws02.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	
	/*
	 * TODO 1. private void saveToFile(List<Board> list, String filename)
	 * list: BoardController에 있는 list 필드
	 * filename: list 객체를 저장할 파일 이름
	 */
	public static<E> void saveToFile(List<E> list, String filename) {
		// FileOutputStream, ObjectOutputStream
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * TODO 2. private List<Board> loadFromFile(String filename)
	 * filename: 게시글 리스트가 저장된 파일명
	 * 
	 * List<Board> : 파일에서 불러온 list 객체를 리턴
	 */
	public static<E> List<E> loadFromFile(String filename) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object list = null;
		
		try {
			File file = new File(filename);	// 해당 파일 객체화
			
			// 파일이 존재 할 경우
			if (file.exists()) {
				fis = new FileInputStream(filename);
				ois = new ObjectInputStream(fis);

				// 파일에 있던 리스트 객체를 끄집어내기
				list = ois.readObject();

				ois.close();
				fis.close();
				
				return (List<E>) list;
			}
			else {
				System.out.println("처음 방문입니다.");
				return new ArrayList<E>();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
