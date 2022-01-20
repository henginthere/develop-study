package com.ssafy.day04.ex04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class FileIOTestDrive {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("sample.mp3");
			fos = new FileOutputStream("sample_copied.mp3");

			long startTime = System.currentTimeMillis();
			System.out.println("복사 시작 시간 ==== " + Calendar.getInstance().getTime());

			try {
				int count = 0;
				while ((count = fis.read()) != -1) {
					fos.write(count);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			long endTime = System.currentTimeMillis();
			System.out.println("복사시간 == " + (endTime - startTime));
			System.out.println("복사 종료 시간 ==== " + Calendar.getInstance().getTime());

		}
		catch (FileNotFoundException e) {

		}
		finally {
			try {
				fos.close();
				fis.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
