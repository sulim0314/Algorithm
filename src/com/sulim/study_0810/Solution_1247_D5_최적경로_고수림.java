package com.sulim.study_0810;

import java.util.Scanner;

public class Solution_1247_D5_최적경로_고수림 {

	static int n, com_x, com_y, home_x, home_y;
	static int[][] arr;

	static int[] before;
	static int[] after;
	static boolean[] visit;
	static int min;

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int tc=1; tc<=testCase; tc++) {
			min = 100000000;
			n = sc.nextInt();
			arr = new int[n][2];
			before = new int[n];
			after = new int[n];
			visit = new boolean[n];
			
			com_x = sc.nextInt();
			com_y = sc.nextInt();
			home_x = sc.nextInt();
			home_y = sc.nextInt();
			
			for(int i=0; i<n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				before[i] = i;
			}
			
			check(0);
			System.out.println("#" + tc + " " + min);
		}
		
	}

	private static void check(int cnt) {
		int temp = 0;
		if(cnt == n) { // 완성됐을 때
			// 회사부터 집1
			temp = Math.abs(com_x-arr[after[0]][0]) + Math.abs(com_y-arr[after[0]][1]);
			// 집1부터 집2, 집2부터 집3,... 집 마지막까지
			for(int i=1; i<n; i++) {
				temp += Math.abs(arr[after[i]][0]-arr[after[i-1]][0]) + Math.abs(arr[after[i]][1]-arr[after[i-1]][1]);
			}
			//집 마지막 부터 우리집까지
			temp += Math.abs(arr[after[n-1]][0]-home_x) + Math.abs(arr[after[n-1]][1]-home_y);
			//최소
			if(min > temp) {
				min = temp;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visit[i]) {
				continue;
			}
			
			after[cnt] = before[i];
			visit[i] = true;
			check(cnt+1);
			visit[i] = false;
		}
		
		
	}
	

}
/*
1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
*/
