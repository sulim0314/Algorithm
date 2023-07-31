package com.ssafy.recursive;

public class RecursiveCallTest1 {
	
	static int N = 10;
	
	public static int sum1(int n) {
		if(n == 1) {
			return 1;
		} else {
			return sum1(n-1) + n;	// -1씩 하면서 내려가기
		}
	}
	
	public static int sum2(int n) {
		if(n == N) {
			return n;
		} else {
			return sum2(n+1) + n;	// +1씩 하면서 올라가기 
		}
	}

	public static int sum3(int n) {
		if(n > 1) {
			return sum3(n-1) + n;
		} 
		return 1;	// 마지막
	}
	
	public static int sum4(int n) {
		if(n < 10) {
			return sum4(n+1) + n;
		} 
		return 10;	// 마지막
	}
	
	public static void main(String[] args) {

		// 하향식 재귀
		System.out.println("sum1 : " + sum1(N));
		
		// 상향식 재귀
		System.out.println("sum2 : " + sum2(1));
		
		// 하향식
		System.out.println("sum3 : " + sum3(N));
		
		// 상향식
		System.out.println("sum4 : " + sum4(1));
		
//		// 1~10까지의 합
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println("sum : " + sum);
//
//		sum = 0;
//		for (int i = 10; i > 0; i--) {
//			sum += i;
//		}
//		System.out.println("sum : " + sum);

	}

}
