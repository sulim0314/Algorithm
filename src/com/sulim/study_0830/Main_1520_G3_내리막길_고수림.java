package com.sulim.study_0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_G3_내리막길_고수림 {

	static int[][] map, dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				dp[i][j] = -1;
			}
		}
		
		dp[N-1][M-1] = 1; //////////////////
		System.out.println(check(0,0));
	}

	private static int check(int x, int y) {
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M) {
				if(map[x][y] > map[nx][ny]) {
					dp[x][y] += check(nx,ny);
				}
			}
		}
		
		return dp[x][y];
		
	}

}
