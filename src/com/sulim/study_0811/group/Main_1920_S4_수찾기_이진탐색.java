package com.sulim.study_0811.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_S4_수찾기_이진탐색 {

	static int N,M,result;
	static int[] arr1,arr2;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr1 = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1); // 1 2 3 4 5
		
		for(int i=0; i<M; i++) { // arr2에 있는 걸 기준으로 arr1에서 찾아보기
			result = 0; // 존재하면 1
			
			check(arr2[i], 0, N-1);
			
			System.out.println(result);
		}
		
		
	}

	private static void check(int now, int start, int end) {

		// 아닐때
		if(start > end) {
			return;
		}
		
		int mid_index = (start + end) / 2;
		
		if(now < arr1[mid_index]) {
			check(now, start, mid_index - 1);
		} else if (arr1[mid_index] < now) {
			check(now, mid_index + 1, end);
		} else if (arr1[mid_index] == now) {
			result = 1;
			return;
		}
		
	}
	
	
	
}
