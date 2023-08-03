package com.sulim.algo_230802.july2023;

import java.util.Arrays;
import java.util.Scanner;

public class ha4 {

	public static void main(String[] args) {

	  /*3 
		3 17 1 39 8 41 2 32 99 2
		22 8 5 123 7 2 63 7 3 46
		6 63 2 3 58 76 21 33 8 1   */
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[] arr = new int[10];
		int count = 1;
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<10; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.println("#"+ count +" "+ arr[9]);
			count++;
		}
		
		
	}
}
