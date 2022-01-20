package com.ssafy.day04.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 키보드로부터 데이터 입력 2 (Java 1.4)
public class InputKeyboard2 {
	
	public static void main(String[] args) {
		String line;
		InputStreamReader isr = null; //Processing Stream, 뒤에 Reader가 붙음. 2byte 씩 처리
		BufferedReader br = null;
		
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			do {
				line = br.readLine();
				System.out.println(line);
				
			} while (line != null);	
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
