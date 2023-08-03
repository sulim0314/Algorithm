package com.sulim.study_0803;

import java.io.IOException;
import java.util.*; 

public class Main_11659_S3_구간합구하기4_고수림 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); 
		int m = sc.nextInt(); 
		int S[] = new int[n + 1]; // S = 구간 합을 구할 대상 배열

		for (int i = 1; i <= n; i++) { 
			S[i] = S[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(); // 몇번째부터 // a[x-1] ~ a[y-1]
			int y = sc.nextInt(); // 몇번째까지 // S[y-1] - S[x-2]
			System.out.println(S[y] - S[x - 1]);
		}

    }
}