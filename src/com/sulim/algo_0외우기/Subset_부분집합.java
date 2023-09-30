package com.sulim.algo_0외우기;

import java.util.Scanner;

public class Subset_부분집합 {

	static int n;
	static int[] data;
	static int[] num;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		data = new int[n];
		num = new int[n];
		
		for(int i=0; i<n; i++) {
			data[i] = i+1;
		}
		
		subset(0,0);
		
	}

	private static void subset(int cnt, int start) {

		for(int i=0; i<n; i++) {
			if(num[i] > 0) {
				System.out.print(num[i] + " ");
			}
		}
		System.out.println();
		
		for(int i=start; i<n; i++) {
			num[cnt] = data[i];
			subset(cnt+1,i+1);
			num[cnt] = 0;
		}
	}


}
