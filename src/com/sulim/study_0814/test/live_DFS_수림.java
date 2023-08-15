package com.sulim.study_0814.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class live_DFS_수림 {

	static int n;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n];

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}

			}

			dfs(0);
			System.out.println();
		}
	}

	private static void dfs(int cur) {

		visited[cur] = true;
		System.out.println();

		for (int ad = 0; ad < n; ad++) {
			if (map[cur][ad] == 1 && !visited[ad]) {
				dfs(ad);
			}
		}

	}

}
