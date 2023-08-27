package com.sulim.study_0827일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972_S3_다음순열 {

	static int N;
	static int[] data;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		data = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		if(np(data)) {
			for(int i=0; i<N; i++) {
				System.out.print(data[i]+" ");
			}
		} else {
			System.out.println(-1);
		}
		
	}

	private static boolean np(int[] p) {

		int n = p.length;
		int i = n-1;
		while(i>0 && p[i-1]>=p[i]) {
			i--;
		}
		
		if(i == 0) return false;
		
		int j = n-1;
		while(p[i-1]>=p[j]) {
			j--;
		}
		swap(p, i-1, j);
		
		int k = n-1;
		while(i < k) {
			swap(p, i++, k--);
		}
		
		return true;
	}

	private static void swap(int[] p, int a, int b) {

		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
		
	}

}
