package com.sulim.연휴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049_G3_행렬곱셈순서_2 {

	static class info {
		int r,c;
		public info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] dp;
	static info [] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		input = new info[N+1];
		
		for(int i=1; i<=N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			input[i] = new info(r, c);
			
			for(int j=1; j<=N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		solve(1, N);
		System.out.println(dp[1][N]);
		
	}

	private static int solve(int start, int end) {
		
		if(start == end) {
			return 0;
		}
		
		if(dp[start][end] != Integer.MAX_VALUE) {
			return dp[start][end];
		}
		
		for(int i=start; i<end; i++) {
			int left = solve(start, i);
			int right = solve(i+1, end);
			
			dp[start][end] = Math.min(dp[start][end], left + right + (input[start].r * input[i].c * input[end].c));
		}
		
		return dp[start][end];
	}

}
