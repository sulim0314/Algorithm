package com.sulim.algo_230802.july2023;

import java.util.Scanner;
import java.util.Arrays;

public class ha3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] score = new int[n];
		
		for(int i=0; i<n; i++) {
			score[i] = sc.nextInt();
		}
		
		Arrays.sort(score);
		
		int result = score[n/2];
		
		System.out.println(result);
		
		
	}

}
