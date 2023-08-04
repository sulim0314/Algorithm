package com.sulim.study_0804;

import java.util.Scanner;

public class test_부분집합4_조합으로바로배열에 {

	static int n;
	static int[] input;
	static int[] numbers;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		input = new int[n];
		numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		subset(0, 0);

	}

	private static void subset(int cnt, int start) {

		for (int i = 0; i < n; i++) {
			if (numbers[i] > 0) {
				System.out.print(numbers[i] + " ");
			}
		}
		System.out.println();

		for (int i = start; i < n; i++) {
			numbers[cnt] = input[i];
			subset(cnt + 1, i + 1);
			numbers[cnt] = 0;
		}

	}

}
