package com.sulim.algo_230802.study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo0728_2018 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int target = Integer.parseInt(st.nextToken()); 

		int count = 0; // 몇개나 되는지 , 결과
		int[] arr = new int[target];

		for (int i = 0; i < target; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < target; i++) { // 시작 포인터 index
			for (int j = i; j < target; j++) { // 끝나는 포인터 index
				int sum = 0;

				for (int start = i; start <= j; start++) {
					sum += arr[start];
				}

				if (sum == target) {
					count++;
				}

			}
		}

		System.out.println(count);

	}

}
