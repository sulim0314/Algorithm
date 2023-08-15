package com.sulim.study_0814.group;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_S4_동전_스터디 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		
		for(int i=N-1; i>=0; i--) {
			int temp = K / arr[i];
			K = K % arr[i];
			result += temp;
		}
		
		System.out.println(result);
	}

}
