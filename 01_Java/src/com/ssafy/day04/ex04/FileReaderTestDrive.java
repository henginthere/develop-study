package com.ssafy.day04.ex04;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTestDrive {
	private FileReader fis;

	public FileReaderTestDrive(String filename) {
		try {
			fis = new FileReader("data.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		finally {
			System.out.println("무조건 실행되는 부분");
		}
	}

	public void readLine() {
		String s = null;

		try {
			BufferedReader bufferedReader = new BufferedReader(fis);
			while ((s = bufferedReader.readLine()) != null) {
				System.out.println(s);
			}
		}
		catch (IOException e) {
			System.out.println("읽기 실패");
		}
		catch (NullPointerException e) {
			System.out.println("File Reader의 객체가 null");
		}
		finally {
			System.out.println("무조건 실행되는 부분2");
		}
	}

	public static void main(String[] args) {
		FileReaderTestDrive testDrive = new FileReaderTestDrive("data.txt");
		testDrive.readLine();
		System.out.println("Program End...");
	}
}
