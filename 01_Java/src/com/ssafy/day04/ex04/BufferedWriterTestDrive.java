package com.ssafy.day04.ex04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterTestDrive {

	public static void main(String[] args) {

		File file = new File("./file/sample_text_file.txt");
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			try {
				bw.append("싸피 여러분 만세!!");
				bw.append("이제 훈민정음을 만드는 것은...");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bw.flush();
				bw.close();
				osw.close();
				fos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
