package com.sulim.study_0827일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2667_S1_단지번호붙이기 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					cnt = 0;
					check(i,j);
					list.add(cnt);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

	private static void check(int x, int y) {

		cnt++;
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(map[x][y] == '1') {
					if(map[nx][ny] == '1' && !visited[nx][ny]) {
						check(nx,ny);
					}
				} 
			}
			
		}
		
		
	}

}
