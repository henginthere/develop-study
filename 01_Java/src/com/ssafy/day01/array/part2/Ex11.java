package com.ssafy.day01.array.part2;

public class Ex11 {
	public static void main(String[] args) {

		// TODO: 교재에 나와있는 문제에서 제시하는 2차원 배열을 생성하고 내용을 출력하시오.
		char[][] grid={{'C','A','A'},{'C','C','B'},{'B','A','B'},{'C','C','C'}};
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
        // END:
	}
}
