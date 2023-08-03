package com.sulim.algo_230802.july2023;

import java.util.Scanner;

public class ha2 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = 0;
		
		while (n > 0) {
            result += n % 10; 
            n /= 10; 
        }
		
		System.out.println(result);
	}
	
}
