package com.sulim.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_G4_가장큰정사각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		
		if (n == 1 && m == 1) {
			System.out.println(1);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			String line = br.readLine();
			for(int j=1; j<=m; j++) {
				map[i][j] = line.charAt(j-1)-'0';
			}
		}

		int answer = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(i==1 && j==1) {
					dp[i][j] = map[1][1];
				} else if(map[i][j] == 1) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		
		System.out.println(answer * answer);
	}
}
