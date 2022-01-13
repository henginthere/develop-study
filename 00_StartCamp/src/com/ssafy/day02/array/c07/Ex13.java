package com.ssafy.day02.array.c07;

public class Ex13 {
	public static void main(String[] args) {

		int[][] grid = {
				{2, 3, 1, 4, 7},
				{8,13, 3,33, 1},
				{7, 4, 5,80,12},
				{17,9,11, 5, 4},
				{4, 5,91,27, 7}
		};

		int count = 0;
		int sum = 0;

		for( int i=0; i<grid.length; i++ ) {
			for( int j=0; j<grid[i].length; j++ ) {
				if( grid[i][j] % 3 == 0 ) {
					count++;
					sum += grid[i][j];
				}
			}
		}

		System.out.println(count);
		System.out.println(sum);
	}
}
