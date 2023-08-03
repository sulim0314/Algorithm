package com.sulim.study_0803;

import java.util.Scanner;

public class hwalgo01_서울_13반_고수림_SWEA2001_파리퇴치 {

	public static void main(String[] args) {
		/*
		1. N 은 5 이상 15 이하이다.
		2. M은 2 이상 N 이하이다.
		3. 각 영역의 파리 갯수는 30 이하 이다.
		*/
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();	
				}
			}
			int max = 0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					
					int sum = 0;
					for(int k=0; k<M; k++) {
						for(int l=0; l<M; l++) {
							sum += arr[i+k][j+l];
						}
					}
					
					max = (max < sum)? sum: max;
					
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
		
	}

}
/*
2
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
6 3
29 21 26 9 5 8
21 19 8 0 21 19
9 24 2 11 4 24
19 29 1 0 21 19
10 29 6 18 4 3
29 11 15 3 3 29
*/
