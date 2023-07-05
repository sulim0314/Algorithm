package july2023;

import java.util.Scanner;

public class Joong2_swea1959 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		int count = 1;

		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] nArr = new int[N];
			int[] mArr = new int[M];

			for (int j = 0; j < N; j++) {
				nArr[j] = sc.nextInt();
			}

			for (int j = 0; j < M; j++) {
				mArr[j] = sc.nextInt();
			}

			
			int max = 0;

			if (N > M) {
				for (int j = 0; j < N - M + 1; j++) {
					int result = 0;
					for (int k = 0; k < M; k++) {
						result += nArr[j + k] * mArr[k];
					}
					max = Math.max(max, result);
				}

			} else if (N < M) {
				for (int j = 0; j < M - N + 1; j++) {
					int result = 0;
					for (int k = 0; k < N; k++) {
						result += nArr[k] * mArr[j + k];
						
					}
					max = Math.max(max, result);
				}
			} else {
				for (int j = 0; j < N; j++) {
					max += nArr[j] * mArr[j];
				}
			}

			System.out.println("#" + count + " " + max);
			count++;

		}

		
		sc.close();
	}
}
