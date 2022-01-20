package com.ssafy.day04.ex04;

// file 관련된 각종 메서드를 사용한 예제
import java.io.File;

public class FileAPITestDrive {

	public static void main(String[] args) {

		File file = new File("TopHoon.txt");

		System.out.println("getName() = " + file.getName());
		System.out.println("getPath() = " + file.getPath());
		System.out.println("getAbsolutePath() = " + file.getAbsolutePath());
		System.out.println("getParent() = " + file.getParent());

		System.out.println("exists() = " + file.exists());
		System.out.println("canWrite() = " + file.canWrite());
		System.out.println("canRead() = " + file.canRead());
		System.out.println("isFile() = " + file.isFile());
		System.out.println("isDirectory() = " + file.isDirectory());
		System.out.println("isAbsolute() = " + file.isAbsolute());

		System.out.println("lastModified() = " + file.lastModified());
		System.out.println("length() = " + file.length());
		System.out.println("delete() = " + file.delete());
		System.out.println("mkdir() = " + file.mkdir());
		System.out.println("toString() = " + file.toString());
		String[] fileList = new File(".").list();

		for (int i = 0; i < fileList.length; ++i) {
			System.out.println("fileList[" + i + "] = " + fileList[i]);
		}

	} // main 종료....
}