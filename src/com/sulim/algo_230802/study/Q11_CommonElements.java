package com.sulim.algo_230802.study;

import java.util.Arrays;
import java.util.Scanner;

public class Q11_CommonElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 1의 개수 >> ");
		int n = sc.nextInt();
		int[] arrN = new int[n];
		
		System.out.print("배열 2의 개수 >> ");
		int m = sc.nextInt();
		int[] arrM = new int[m];
		int capacity = (n > m)? n: m;
		int[] answer = new int[capacity];
		
		System.out.print("배열 1에 저장할 값을 오름차순으로 입력 >> ");
		for(int i=0; i<n; i++) {
			arrN[i] = sc.nextInt();
		}
		System.out.print("배열 2에 저장할 값을 오름차순으로 입력 >> ");
		for(int i=0; i<m; i++) {
			arrM[i] = sc.nextInt();
		}

		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arrN[i] == arrM[j]) {
					answer[index++] = arrM[j];
					break;
				}
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i] == 0) {
				break;
			}
			System.out.print(answer[i]+" ");
		}
	}
}
