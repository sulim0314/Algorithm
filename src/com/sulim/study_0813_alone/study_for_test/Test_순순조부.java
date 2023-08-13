package com.sulim.study_0813_alone.study_for_test;

import java.util.Arrays;
import java.util.Scanner;

public class Test_순순조부 {
	
	static int n;
	static int r;
	static int[] data;
	static int[] num;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		//r = sc.nextInt();
		
		data = new int[n];
		//num = new int[r];
		num = new int[n];
		//visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			data[i] = i+1;
		}
				
		//per_visit(0);
		//per_bit(0,0);
		//combi(0,0);
		subset(0,0);
	}

	private static void subset(int cnt, int start) {

		for(int i=0; i<n; i++) {
			if(num[i] > 0) {
				System.out.print(num[i]+" ");
			}
		}
		
		System.out.println();
		
		for(int i=start; i<n; i++) {
			num[cnt] = data[i];
			subset(cnt+1, i+1);
			num[cnt] = 0;
		}
		
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

	private static void per_bit(int cnt, int flag) {

		if(cnt == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for(int i=0; i<n; i++) {
			if((flag & 1<<i) != 0) {
				continue;
			}
			num[cnt] = data[i];
			per_bit(cnt+1, flag | 1<<i);
		}
	}

	private static void per_visit(int cnt) {

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
			per_visit(cnt+1);
			visit[i] = false;
		}
		
		
	}

}
