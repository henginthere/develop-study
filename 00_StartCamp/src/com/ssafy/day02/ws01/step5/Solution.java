/*
 *  데일리 실습_Java_01_5
 *  Java 01. 2차원배열 응용
 *  
 */
package com.ssafy.day02.ws01.step5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	
	static int m,n;
	static boolean[][] visited;
	static int[] dx = {-1,-1,-1,0,1,1,1,0}; 
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	static int cnt=0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ws01_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		String line;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int L=Integer.parseInt(in.readLine());
			for (int inputline=1;inputline<=L;inputline++) {
				line=in.readLine();
				System.out.print("#" + test_case + " ");
				System.out.println(line);
			}
			
		
			
			
			
		}
	}
}
