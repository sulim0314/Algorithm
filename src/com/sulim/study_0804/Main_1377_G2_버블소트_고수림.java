package com.sulim.study_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1377_G2_버블소트_고수림 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(br.readLine());
			arr[i][1] = i; // 원래 인덱스를 저장
		}

		// 배열을 값 기준으로 오름차순 정렬
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		int maxMove = 0;
		for (int i = 0; i < n; i++) {
			// 정렬된 배열과 원래 인덱스를 비교하여 최대 이동 횟수를 구한다.
			maxMove = Math.max(maxMove, arr[i][1] - i);
		}

		// 최대 이동 횟수는 0부터 시작하므로 1을 더한다.
		System.out.println(maxMove + 1);
	}
	
}

/*
5
10
1
5
2
3
 */