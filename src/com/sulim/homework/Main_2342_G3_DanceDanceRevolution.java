package com.sulim.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2342_G3_DanceDanceRevolution {

	static int[] input;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		input = new int[s.length-1];
		for(int i=0; i<s.length-1; i++) {
			input[i] = Integer.parseInt(s[i]);
		}
		
		// dp : left, right, cnt
		// 0,1,2,3,4 만 존재하니까 size = 5
		dp = new int[5][5][s.length];
		
		int answer = DDR(0, 0, 0);
		System.out.println(answer);
	}

	private static int DDR(int left, int right, int cnt) {
		
		if(cnt == input.length) return 0;
		
		if(dp[left][right][cnt] != 0) return dp[left][right][cnt];
		
		int leftScore = score(left, input[cnt]) + DDR(input[cnt], right, cnt+1);
		int rightScore = score(right, input[cnt]) + DDR(left, input[cnt], cnt+1);
		
		return dp[left][right][cnt] = Math.min(leftScore, rightScore);
	}
	
	private static int score(int from, int to) {
		if(from == to) return 1;
		if(from == 0) return 2;
		if(Math.abs(from-to) == 2) return 4;
		return 3;
	}

}
