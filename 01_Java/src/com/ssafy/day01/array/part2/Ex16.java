package com.ssafy.day01.array.part2;

public class Ex16 {
	public static void main(String[] args) {

		int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		char[][] grid = {{'2', '3', '1', '4'},
				{'1', 'X', '3', '2'},
				{'3', '4', 'X', 'X'},
				{'X', '4', '1', '5'}};

		int sum = 0;
		// TODO: X로 표시된 항목의 상하좌우 숫자의 합을 구하시오.
		// 단, 합을 구할 때 이미 사용된 숫자는 다시 사용하지 않음
		// 예) 3행 2열의 숫자 4는 위의 X와 우측의 X에 모두 인접하지만 한번만 더한다.
		
		// END:
		System.out.println(sum);
	}
}
