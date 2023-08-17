package com.sulim.study_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class xy {
	int x;
	int y;

	public xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main_1661_미로탈출로봇_고수림 {

	static int n, m;
	static int x1, y1, x2, y2;
	static int[][] map;
	static int[][] map2;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		y1 = Integer.parseInt(st.nextToken()) - 1; // 출발은 x1, y1
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1; // 도착은 x2, y2
		x2 = Integer.parseInt(st.nextToken()) - 1;

		map = new int[m][n];
		map2 = new int[m][n];

		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
				map2[i][j] = Integer.MAX_VALUE;
			}
		}

		bt(x1, y1, 0);
		System.out.println(map2[x2][y2]+1);

	}

	private static void bt(int x, int y, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0) {
				if(cnt < map2[nx][ny]) {
					map2[nx][ny] = Math.min(map2[nx][ny], cnt);
					bt(nx,ny,cnt+1);
				}
			}
			
		}

		
	}


}
