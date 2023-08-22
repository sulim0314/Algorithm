package com.sulim.study_0822.group;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_G5_집합의표현_고수림 {

	static int M, N;
	static int parents[];

	private static void make() {
		parents = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 합집합
			if (tmp == 0) {
				union(a, b);
				// 같은 집합에 포함되어 있는가
			} else if (tmp == 1) {
				int aa = find(a);
				int bb = find(b);
				if (aa == bb) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}

	}

}
