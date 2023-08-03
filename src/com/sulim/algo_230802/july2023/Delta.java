package com.sulim.algo_230802.july2023;

import java.util.Scanner;

public class Delta {
	
//	map[i-1][j] = 1; //상
//	map[i+1][j] = 1; //하
//	map[i][j-1] = 1; //좌
//	map[i][j+1] = 1; //우
//
//	map[i-1][j-1] = 1; //좌상
//	map[i-1][j+1] = 1; //우상
//	map[i+1][j-1] = 1; //좌하
//	map[i+1][j+1] = 1; //우하
	
	
//  상 하  좌 우 좌상,우상, 좌하, 우하
//상하좌우를 변경시켜줄 direction 델타배열 !!!!
//int[] dr = {-1, 1, 0, 0 ,-1, -1,    1,   1};	
//int[] dc = { 0, 0,-1, 1, -1,  1,   -1,   1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();

		int[] dr = {-1, 1, 0, 0 ,-1, -1,    1,  1};	
		int[] dc = { 0, 0,-1, 1, -1,  1,   -1,  1};
		
		int nr, nc, n = dr.length;
		for(int i=0; i<n; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				map[nr][nc] = 1;
			}
			
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
