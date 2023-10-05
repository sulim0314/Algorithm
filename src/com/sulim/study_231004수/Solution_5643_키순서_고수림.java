package com.sulim.study_231004수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5643_키순서_고수림 {

	static int N;
	static boolean[][] bool;
	static boolean[] visited1, visited2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			bool = new boolean[N][N];
			visited1 = new boolean[N];
			visited2 = new boolean[N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				bool[a][b] = true;
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited1, false);
				Arrays.fill(visited2, false);

				int big = dfs(i);
				int small = dfs2(i);

				if (big + small == N - 1) {
					count++;
				}
			}

			System.out.println("#" + t + " " + count);
		}
	}

	private static int dfs(int start) {
		int count = 0;

		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			int current = stack.pop();

			for (int i = 0; i < N; i++) {
				if (bool[current][i] && !visited1[i]) {
					visited1[i] = true;
					stack.push(i);
					count++;
				}
			}
		}
		return count;
	}

	private static int dfs2(int start) {

		int count = 0;

		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			int current = stack.pop();

			for (int i = 0; i < N; i++) {
				if (bool[i][current] && !visited2[i]) {
					visited2[i] = true;
					stack.push(i);
					count++;
				}
			}
		}
		return count;
	}

}
