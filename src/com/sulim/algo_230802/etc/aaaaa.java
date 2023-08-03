package com.sulim.algo_230802.etc;
public class aaaaa {

	public int solution(int[] arr) {
		int lcm = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			lcm = getLcm(lcm, arr[i]);
		}
		
		return lcm;
	}

	public int getGcd(int a, int b) {
		int tmp;
		while(b != 0) {
			tmp = b;
			b = a % b;
			a = tmp;
		}
		
		return a;
	}

	public int getLcm(int a, int b) {
		return a * b / getGcd(a, b);
	}
}
