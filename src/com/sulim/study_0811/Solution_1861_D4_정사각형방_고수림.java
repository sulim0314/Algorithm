package com.sulim.study_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_D4_정사각형방_고수림 {

	static int[][] map;
	static int n; 
	static int cnt;
	static int first, max_room;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=tc; test++) {
			first = Integer.MAX_VALUE;
			max_room = 1;
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) { // 처음방 index
					cnt = 1;
					check(i,j);
					if(cnt >= max_room) {
						if (cnt == max_room) {
							max_room = cnt;
							first = Math.min(first, map[i][j]);
						} else {
							max_room = cnt;
							first = map[i][j];
						}
					}
				}
			}
			System.out.println("#"+ test +" "+ first +" "+ max_room );
		}
		
		
	}

	private static void check(int x, int y) {
		
		// 상
		if(0<=x-1 && map[x][y]+1 == map[x-1][y]) {
			cnt++;
			check(x-1,y);
		}
		// 하
		else if(x+1<=n-1 && map[x][y]+1 == map[x+1][y]) {
			cnt++;
			check(x+1,y);
		}
		// 좌
		else if(0<=y-1 && map[x][y]+1 == map[x][y-1]) {
			cnt++;
			check(x,y-1);
		}
		// 우
		else if(y+1<=n-1 && map[x][y]+1 == map[x][y+1]) {
			cnt++;
			check(x,y+1);
		}
		else {
			return;
		}
		
	}


}
