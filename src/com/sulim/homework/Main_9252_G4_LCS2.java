package com.sulim.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9252_G4_LCS2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		
		int h = s1.length;
		int w = s2.length;
		
		int[][] dp = new int[h+1][w+1];
		
		for(int i=1; i<=h; i++) {
			char c1 = s1[i-1];
			
			for(int j=1; j<=w; j++) {
				char c2 = s2[j-1];
				
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int answer = dp[h][w];
		System.out.println(answer);
		
		// path
		if(answer != 0) {
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<Character>();
			
			int x = w;
			int y = h;
			int cur = dp[y][x];
			
			while(dp[y][x] != 0) {
				if(dp[y-1][x] == cur) {
					y--;
				} else if(dp[y][x-1] == cur) {
					x--;
				} else if(dp[y-1][x-1] == cur-1) {
					stack.push(s2[x-1]);
					cur--;
					y--;
					x--;
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb);
		}
		
		
	}

}
