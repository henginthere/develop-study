package com.ssafy.day04.ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class BufferedReaderTestDrive {

	public static void main(String[] args) {
		
		/*FileInputStream fis = null;
		InputStreamReader isr = null;*/
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			URL myUrl = new URL("https://www.naver.com");

			/*FileInputStream fis = new FileInputStream("data.txt");
			InputStreamReader isr = new InputStreamReader(fis);*/
			isr = new InputStreamReader(myUrl.openStream(), "UTF-8");
			br = new BufferedReader(isr);
			String s = new String();

			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				isr.close();
				/*fis.close();*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
