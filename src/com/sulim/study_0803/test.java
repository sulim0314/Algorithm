package com.sulim.study_0803;

import java.util.Arrays;
import java.util.Scanner;

public class test {

	static String[] datas = "abcd".split("");
	static int N = datas.length;
	static int[] subset = new int[datas.length];

	private static void print() {
		int k = 0;
		System.out.print("[");
		for (int s : subset) {
			if (s != 0) {
				System.out.print(datas[k] + " ");
				k++;
			}
		}
		System.out.print("] \n");
	}

	public static void main(String[] args) {

		// bitmask를 이용해서 부분집합을 표현하기 시간복잡도 : 2 ^ n*n
		for (int i = 0, end = 1 << N; i < end; i++) { // 부분집합의 개수만큼 반복

			// 반복 변수 i의 bit가 부분집합으로 표현하므로
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) { // 1인 원소를 택한것임. j번째 bit가 0이 아니면 원소를 선택(1)한 것. 0이면 비선택.
					subset[j] = 1;
				}
			}

			print();
			Arrays.fill(subset, 0);

		}

	}

}
