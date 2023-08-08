package com.sulim.study_0808.test_순열조합부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class test_2조합 {

	// nCr
	static int n;
	static int r;
	static int[] data;
	static int[] num;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		
		data = new int[n];
		num = new int[r];
		
		for(int i=0; i<n; i++) {
			data[i] = i+1;
		}
 		
		combi(0,0);
		
	}

	private static void combi(int cnt, int start) {

		if(cnt == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=start; i<n; i++) {
			num[cnt] = data[i];
			combi(cnt+1, i+1);
		}
		
		
	}

}
