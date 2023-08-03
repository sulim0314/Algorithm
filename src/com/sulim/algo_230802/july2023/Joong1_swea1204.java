package com.sulim.algo_230802.july2023;

import java.util.Scanner;

public class Joong1_swea1204 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			
			int[] arr = new int[101];
			int tc = sc.nextInt();
			
			for(int j=0; j<1000; j++) {
				int n = sc.nextInt();
				arr[n]++;
			}
			
			int max = 0;
			int result = 0;
			
			for(int j=0; j<101; j++) { // index 0 ~ 100
				if(arr[j] >= max) {
					max = arr[j];
					result = j;
				}
			}
			
			System.out.println("#"+ tc +" "+ result);
		}
		
		
		
	}

}
