package com.sulim.algo_0외우기;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_순열_visit {

	static int n;
	static int r;
	static int[] data;
	static int[] num;
	static boolean[] visit;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		visit = new boolean[n];
		data = new int[n];
		num = new int[r];
		
		for(int i=0; i<n; i++) {
			data[i] = i+1;
		}
		
		per(0);
		
	}

	private static void per(int cnt) {
		
		if(cnt == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visit[i]) {
				continue;
			}
			num[cnt] = data[i];
			visit[i] = true;
			per(cnt+1);
			visit[i] = false;
		}
		
	}

}
