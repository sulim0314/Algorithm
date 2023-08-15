package com.sulim.study_0814.test;

import java.util.Arrays;

public class live_NP_수림 {

	public static void main(String[] args) {

		int[] data = {1,6,4,8};
		int n = data.length;
		
		Arrays.sort(data);
		
		do {
			System.out.println(Arrays.toString(data));
		} while(np(data));
		
	}

	private static boolean np(int[] p) {
		
		int n = p.length;
		int i = n-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		
		if(i == 0) return false;
		
		int j=n-1;
		while(p[i-1] >= p[j]) --j;
		swap(p, i-1, j);
		
		int k = n-1;
		while(i < k) swap(p, i++, k--);
		
		return true;
		
	}

	private static void swap(int[] p, int a, int b) {

		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
		
	}

}
