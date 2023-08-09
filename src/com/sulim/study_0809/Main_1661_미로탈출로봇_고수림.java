package com.sulim.study_0809;

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
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int breadth;

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

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
		System.out.println(breadth);
		
	}

	private static void bfs() {

		Queue<xy> q = new LinkedList<>(); // 방문할 Node를 담을 Queue
		q.add(new xy(x1, y1));
		breadth = 0;
		
		// 방문한 노드를 체크
		map[x1][y1] = 1;

		// 모든 노드를 방문해 보기
		while (!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				xy temp = q.poll(); // 방문할 기준 노드 하나 꺼내오기
				int x = temp.x;
				int y = temp.y;
				if(x == x2 && y == y2) {
					return;
				}
				
				// 인접한 노드를 방문하기
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.add(new xy(nx, ny));
					}
				}
				
			}

			breadth++;
		}

	}

}
