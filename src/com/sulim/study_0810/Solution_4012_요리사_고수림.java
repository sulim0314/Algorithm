package com.sulim.study_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사_고수림 {

	static int T;
	static int N, M;
	static int[][] map;
	static int[] before;
	static int[] after;
	static int end;
	static int count;
	static int left;
	static int right;
	static int min;
	static int[] leftArr;
	static int[] rightArr;
	static int[] leftNum;
	static int[] rightNum;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = N/2;	// 각각 재료 개수
			
			map = new int[N][N];
			
			before = new int[N];
			after = new int[N/2];
			select = new boolean[N];
			
			leftArr = new int[N/2];
			rightArr = new int[N/2];
			
			leftNum = new int[2];
			rightNum = new int[2];
			min = 100000000;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				before[i] = i;
			}
			
			check(0,0);
			
			System.out.println("#"+testCase+" "+min);
		}
		
		
	}

	private static void check(int cnt, int start) {
		 
		if(cnt == N/2) { // 조합 다 됐으면, 
			calculate();
			return;
		}
		
		for(int i=start; i<N; i++) {
			after[cnt] = before[i];
			check(cnt+1, i+1);
		}
		
		
	}

	private static void calculate() {
		select = new boolean[N];
		left = 0;
		right = 0;
		int leftCount = 0;
		int rightCount = 0;
		
		// 왼쪽반, 오른쪽 반 넣기
		for(int i=0; i<N/2; i++) {
			select[after[i]] = true;
		}
		
		for(int i=0; i<N; i++) {
			if(select[i]) {
				leftArr[leftCount] = i;
				leftCount++;
			} else {
				rightArr[rightCount] = i;
				rightCount++;
			}
			
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				left += map[leftArr[i]][leftArr[j]];
				right += map[rightArr[i]][rightArr[j]];
			}
		}
		
		if(min > Math.abs(left-right)) {
			min = Math.abs(left-right);
		}
		
	}



}


/*
1
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
*/
