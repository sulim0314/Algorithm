package com.sulim.algo_230802.july2023;

import java.util.Arrays;
import java.util.Scanner;

public class ha5 {

	public static void main(String[] args) {

	  /*3
		3 17 1 39 8 41 2 32 99 2
		22 8 5 123 7 2 63 7 3 46
		6 63 2 3 58 76 21 33 8 1   */
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int sum = 0;
		int count = 1;
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<10; j++) {
				int n = sc.nextInt();
				if(n % 2 == 1) {
					sum += n;
				}
			}
			System.out.println("#"+ count +" "+ sum);
			count++;
			sum = 0;
		}
	}
}
