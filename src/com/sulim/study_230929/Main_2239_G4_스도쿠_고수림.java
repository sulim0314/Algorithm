package com.sulim.study_230929;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2239_G4_스도쿠_고수림 {

	static int[][] map;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			
			for(int j=0; j<9; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		dfs(0,0);
		
	}

	private static void dfs(int x, int y) {
		
		if(y == 9) {
			dfs(x+1, 0);
			return;
		}
		
		// 9,9 까지 다 돌았을 때
		if(x == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0); // 꼭
		}
		
		if(map[x][y] == 0) {
			for(int i=1; i<10; i++) {
				// x,y자리에 1부터 9까지 들어갈 수 있는지 check
				if(check(x,y,i)) { // 갈 수 있다면
					map[x][y] = i;
					dfs(x, y+1);
					map[x][y] = 0;
				}
			}
			return;
		}
		dfs(x, y+1);
		
	}

	private static boolean check(int x, int y, int num) {

		// 가로 체크
		for(int i=0; i<9; i++) {
			if(map[x][i] == num) { // 이미 num이 있으면 못감
				return false;
			}
		}
		
		// 세로 체크
		for(int i=0; i<9; i++) {
			if(map[i][y] == num) {
				return false;
			}
		}
		
		// 네모박스 체크
		int row = (x/3)*3;
		int col = (y/3)*3;
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(map[i][j] == num) { 
					return false;
				}
			}
		}
		
		return true;
	}

	
}

