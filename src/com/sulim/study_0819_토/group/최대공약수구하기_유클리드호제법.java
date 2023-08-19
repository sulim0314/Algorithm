package com.sulim.study_0819_토.group;

import java.util.Arrays;
import java.util.Stack;


public class 최대공약수구하기_유클리드호제법{
	public static void main(String[] args) {
        int num1 = 48;
        int num2 = 60;

        int gcd = getGcd(num1, num2);
        System.out.println("the greatest common denominator : " + gcd);
        System.out.println("the lowest common multiple : " + (num1 * num2) / gcd);
        
    }

    // 최대공약수를 구하는 유클리드 호제법 함수
 	private static int getGcd(int a, int b) {
 		if (b == 0) {
 			return a;
 		}
 		return getGcd(b, a % b);
 	}
}
