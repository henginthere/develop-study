package com.ssafy.day02.array.c06;

public class Ex06 {
	public static void main(String[] args) {

		String [] students = { "홍길동", "박사피", "윤멀티", "나자바" }; 

		for( String student : students ) {
			System.out.println(student);
		}

		String temp = students[1];
		students[1] = students[2];
		students[2] = temp;

		for( String student : students ) {
			System.out.println(student);
		}
	}
}
