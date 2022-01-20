package com.ssafy.day04.ex04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class BufferedIOTestDrive {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream("sample.mp3");
			fos = new FileOutputStream("sample_copied.mp3");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			long startTime = System.currentTimeMillis();
			System.out.println("복사 시작 시간 ==== " + Calendar.getInstance().getTime());

			try {
				byte[] buffer = new byte[100];

				while (bis.read(buffer) != -1) {
					bos.write(buffer);
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
				bos.close();
				bis.close();
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
