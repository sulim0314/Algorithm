package com.sulim.algo_230802.july2023;

import java.util.Scanner;

public class Joong5_swea12712 {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수 입력

        for (int caseNum = 1; caseNum <= T; caseNum++) {
        	
            int N = sc.nextInt(); // N 입력
            int M = sc.nextInt(); // M 입력
            int[][] flies = new int[N][N]; // N x N 배열 생성

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    flies[i][j] = sc.nextInt(); // 배열 요소 입력
                }
            }

            
            int maxFlies = 0; // 최대 파리 수 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                	
                    int sum = 0; // 파리 수 누적 변수 초기화

                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            sum += flies[k][l]; // 파리 수 누적
                        }
                    }

                    if (sum > maxFlies) {
                        maxFlies = sum; // 최대 파리 수 갱신
                    }
                }
            }

            
            System.out.println("#" + caseNum + " " + maxFlies); // 결과 출력
        }

        sc.close();
    }

}
