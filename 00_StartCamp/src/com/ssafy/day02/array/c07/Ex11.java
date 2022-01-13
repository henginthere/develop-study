package com.ssafy.day02.array.c07;

public class Ex11 {
	public static void main(String[] args) {

		char[][] grid = new char[4][3];

		grid[0][0] = 'C'; grid[0][1] = 'A'; grid[0][2] = 'A';
		grid[1][0] = 'C'; grid[1][1] = 'C'; grid[1][2] = 'B';
		grid[2][0] = 'B'; grid[2][1] = 'A'; grid[2][2] = 'C';
		grid[3][0] = 'C'; grid[3][1] = 'C'; grid[3][2] = 'C';

		for( int i=0; i<grid.length; i++ ) {
			for( int j=0; j<grid[i].length; j++ ) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
