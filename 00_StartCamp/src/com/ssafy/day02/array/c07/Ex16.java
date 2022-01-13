package com.ssafy.day02.array.c07;

import java.util.Scanner;

public class Ex16 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[][] grid = new char[4][4];
		boolean[][] used = new boolean[4][4];
		
		int sum = 0;
		
		for( int i=0; i<4; i++ )
			for( int j=0; j<4; j++ )
				grid[i][j] = sc.next().charAt(0);

		for( int i=0; i<4; i++ )
			for( int j=0; j<4; j++ )
				if( grid[i][j] == 'X') {
					if( i-1 >= 0 && grid[i-1][j] != 'X' && ! used[i-1][j] ) { 
						sum += grid[i-1][j] - '0';
						used[i-1][j] = true;
					}
					if( i+1 < 4 && grid[i+1][j] != 'X' && ! used[i+1][j] ) { 
						sum += grid[i+1][j] - '0';
						used[i+1][j] = true;
					}
					if( j-1 >= 0 && grid[i][j-1] != 'X' && ! used[i][j-1] ) { 
						sum += grid[i][j-1] - '0';
						used[i][j-1] = true;
					}
					if( j+1 < 4 && grid[i][j+1] != 'X' && ! used[i][j+1] ) { 
						sum += grid[i][j+1] - '0';
						used[i][j+1] = true;
					}
				}
		
		System.out.println(sum);
		sc.close();
	}
}
