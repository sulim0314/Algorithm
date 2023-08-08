package com.sulim.study_0807;

import java.util.Arrays;
import java.util.Scanner;

public class test {

	static int N;
	//static int R;
	static int[] data;
	static int[] num;
	//static boolean[] visit;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		//R = sc.nextInt();
		
		data = new int[N];
		num = new int[N];
		
		for(int i=0; i<N; i++) {
			data[i] = i+1;
		}
		
		subset(0, 0);
		
		
	}
	
	private static void subset(int cnt, int start) {

		for(int i=0; i<N; i++) {
			if(num[i] > 0) {
				System.out.print(num[i] + " ");
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
