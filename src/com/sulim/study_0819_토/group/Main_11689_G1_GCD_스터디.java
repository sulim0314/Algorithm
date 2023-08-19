package com.sulim.study_0819_토.group;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 자연수 n이 주어졌을 때, 최대공약수가 1인 k의 개수
public class Main_11689_G1_GCD_스터디 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		long result = n;

		for(int i=2; i<Math.sqrt(n)+1; i++) {
			if(n % i == 0) { // 약수일 때
				result = result - (result/i); // 오일러의 피 함수 개념 이용
				while(n % i == 0) { 
					n = n/i;
				}
			}
		} // n이 1이 될때까지 소인수로 나눠준다.
		
		// n이 계속 갱신되기 때문에 .. 마지막에 해줘야함.
		if(n > 1) {
			result = result - result/n;
		}
		
		System.out.println(result);
		
	}

}
