package com.sulim.study_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_D4_준환이의양팔저울_고수림 {

	static int N;
	static int[] data;
	static int[] num;
	static boolean[] visit;
	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tc = Integer.parseInt(st.nextToken());

		for (int test = 1; test <= tc; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			result = 0;

			data = new int[N];
			num = new int[N];
			visit = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}

			per_visit(0);

			System.out.println("#" + test + " " + result);
		}

	}

	private static void per_visit(int cnt) {
		if (cnt == N) {
			check(0, 0, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				continue;
			}

			num[cnt] = data[i];
			visit[i] = true;
			per_visit(cnt + 1);
			visit[i] = false;
		}

	}

	private static void check(int left, int right, int count) {

		if(left < right) {
			return;
		} 
		
		if(count == N) {
			result++;
			return;
		}
		
		check(left+num[count], right, count+1);
		check(left, right+num[count], count+1);
		
	}

}
