package com.sulim.study_0904;

import java.util.Scanner;

public class Main_2579_S3_계단오르기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+2];
        int[] step = new int[N+2];
        
        for(int i=1; i<=N; i++) {
            step[i] = sc.nextInt();
        }
        
        dp[1] = step[1];
        dp[2] = Math.max(step[1]+step[2], step[2]);
        
        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i-2]+step[i], dp[i-3]+step[i-1]+step[i]);
        }
        
        System.out.println(dp[N]);
        
    }

}