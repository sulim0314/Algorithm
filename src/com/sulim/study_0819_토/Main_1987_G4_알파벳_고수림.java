package com.sulim.study_0819_토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_G4_알파벳_고수림 {

	static int R,C;
	static char[][] map;
	static boolean[] visited;
	static int max=0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[26]; // 대문자는 65 ~ 90, 0 ~ 25
		
		solve(0,0,1);
		
		System.out.println(max);
		
	}
	
	

	private static void solve(int x, int y, int cnt) {
		
		visited[map[x][y] - 'A'] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map 범위 안에 있을 때
			if(0<=nx && nx<R && 0<=ny && ny<C) {
				// 방문하지 않았을 때
				if(!visited[map[nx][ny]-'A']) {
					solve(nx, ny, cnt+1);
				}
			}
		}
		
		visited[map[x][y] - 'A'] = false; // 해당 알파벳 방문 초기화
		max = Math.max(max, cnt);
		
	}

}
