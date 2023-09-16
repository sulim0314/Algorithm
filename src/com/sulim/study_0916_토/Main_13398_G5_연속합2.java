package com.sulim.study_0916_토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13398_G5_연속합2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, ans;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		init();
		solution();
	}

	private static void solution() {
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		ans = arr[0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
			ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(ans);
	}
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		dp = new int[N][2];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}