package com.ssafy.day04.ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		if (args.length != 2) { //args 입력이 2개가 아닐 때
			System.out.println("Usage: java FileCopy sourceFile destFile");
			System.exit(1); //비정상종료
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(args[0]);  // 읽을 파일
			fos = new FileOutputStream(args[1]);  // 쓸 파일
			
			int ch;
			while ((ch = fis.read()) != -1) {  // -1은 파일 내용의 끝을 리턴시키는 숫자. EOF임 End Of File
				fos.write((byte) ch);  // 이진코드로 읽고 쓰는 메서
			}
		}
		catch (IOException e) {
			System.out.println("ERROR " + e.toString());
		}
		finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// 한 바이트씩 읽어서 복사하므로 속도가 떨어진다.
}
