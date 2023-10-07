package com.sulim.LIS;

public class LIS1 {
	public static void main(String[] args) {
		int[] a = { 3, 2, 6, 4, 5, 1 };
		int n = a.length;

		// 각수를 끝에 세울 수 있는 LIS의 길이를 저장하는 배열
		int[] lis = new int[n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			// 초기 값 설정, 일단 현재 수를 시작으로 하는 LIS를 만들 수 있으므로 초기 값을 1로 설정한다.
			lis[i] = 1;

			// 맨 처음 원소부터, 현재 수를 끝으로 하는 LIS의 길이 중 가장 큰 수에 현재 수를 붙이기
			for (int j = 0; j < i; j++) {
				// i번째 수보다 작아서 i를 끝으로 세울 수 있고
				if (a[j] < a[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1; // 현재 수를 끝으로 하는 LIS 길이 갱신
				}
			}

			// max 값 갱신
			max = Math.max(max, lis[i]);
		}

		System.out.println("최장 증가 수열의 길이 : " + max);
	}
}