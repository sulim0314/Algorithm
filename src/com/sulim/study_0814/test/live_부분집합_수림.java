package com.sulim.study_0814.test;

import java.util.Scanner;

public class live_부분집합_수림 {

	static int N;
	static int[] data;
	static int[] num;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		data = new int[N];
		num = new int[N];
		
		for(int i=0; i<N; i++) {
			data[i] = i+1;
		}
		
		subset(0,0);
		
	}

	private static void subset(int cnt, int start) {

		for(int i=0; i<N; i++) {
			if(num[i] > 0) {
				System.out.print(num[i] +" ");
			}
		}
		System.out.println();
		
		for(int i=start; i<N; i++) {
			num[cnt] = data[i];
			subset(cnt+1, i+1);
			num[cnt] = 0;
		}
		
	}

}
