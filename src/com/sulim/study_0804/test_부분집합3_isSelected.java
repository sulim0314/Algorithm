package com.sulim.study_0804;

import java.util.Scanner;

public class test_부분집합3_isSelected {
	
	static int N;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0);
	}

	private static void generateSubset(int cnt) {

		if(cnt == N) {
			for(int i=0; i<N; i++) {
//				System.out.print((isSelected[i]?input[i]:"X")+"\t");
				
				if(isSelected[i]) {
					System.out.print(input[i]);
				}
			}
			
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}
