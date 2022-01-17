package com.ssafy.day01.array.part1;

public class Ex06 {
	public static void main(String[] args) {

		String[] students = {"홍길동", "임꺽정", "장길산", "이몽룡"};
        // TODO: 배열에서 임꺽정과 장길산의 위치를 변경해서 출력하시오.
		String temp=students[1];
		students[1]=students[2];
		students[2]=temp;
		for (String x:students)
			System.out.println(x);
        // END:
	}
}
