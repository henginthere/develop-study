package com.ssafy.day04.ex01;

import java.io.File;

public class FileInfo {
	
	public static void main(String[] args) {//args는 문자열배열. "filename"이 들어가있다.
		
		if (args.length != 1) {
			System.out.println("Usage: java FileInfo filename");
			System.exit(0); //정상종료를 vm에게 알려주기
		}
		
		File file = new File(args[0]);
		if (file.exists()) {
			System.out.println("파일 이름 : " + file.getName());
			System.out.println("상대 경로 : " + file.getPath());
			System.out.println("절대 경로 : " + file.getAbsolutePath());
			System.out.println("쓰기 가능 : " + file.canWrite());
			System.out.println("읽기 가능 : " + file.canRead());
			System.out.println("파일 길이 : " + file.length() + " 바이트");
			
		}
		else {
			System.out.println(args[0] + "not found");
		}
	}
}
