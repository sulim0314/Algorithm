package com.sulim.algo_230802.july2023;

import java.util.Scanner;

public class Joong3_swea1961 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; i++) {
			System.out.println("#"+ (i+1));
			
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int[][] result_90 = Rotate(arr);
			int[][] result_180 = Rotate(result_90);
			int[][] result_270 = Rotate(result_180);
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					System.out.print(result_90[j][k]);
				}
				System.out.print(" ");
				
				for(int k=0; k<n; k++) {
					System.out.print(result_180[j][k]);
				}
				System.out.print(" ");
				
				for(int k=0; k<n; k++) {
					System.out.print(result_270[j][k]);
				}
				System.out.println();
			}

			
		}
		
	}
	
	public static int[][] Rotate(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				result[i][j] = arr[arr.length-1-j][i];
			}
		}
		
		return result;
	}

}
