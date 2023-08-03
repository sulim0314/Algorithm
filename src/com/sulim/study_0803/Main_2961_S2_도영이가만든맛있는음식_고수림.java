package com.sulim.study_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2961_S2_도영이가만든맛있는음식_고수림 {

	static int N;
	static int[] S_arr;
	static int[] B_arr;
	
	static int min = 1_000_000_000;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		S_arr = new int[N];
		B_arr = new int[N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S_arr[i] = Integer.parseInt(st.nextToken());
			B_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		generateSubset(0, 0);
		System.out.println(min);
	}

	private static void generateSubset(int cnt, int start) {

		if(cnt >= 1) {
			min = Math.min(min, cal());
		}
		
		for(int i=start; i<N; i++) {
			visit[i] = true;
			generateSubset(cnt+1, i+1);
			visit[i] = false;
		}
		
	}

	private static int cal() {

		int S_result = 1;
		int B_result = 0;
		
		for(int i=0; i<N; i++) {
			if(visit[i]) {
				S_result *= S_arr[i];
				B_result += B_arr[i];
			}
		}
		
		return Math.abs(S_result - B_result);
	}

}
