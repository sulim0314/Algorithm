package com.sulim.study_0804;

import java.util.Scanner;
import java.util.Stack;

public class Main_1141_G5_불쾌한날_고수림 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Stack<Integer> s = new Stack<Integer>();

		long sum = 0;
		s.push(sc.nextInt());
		
		for(int i=1; i<n; i++) {
			int tmp = sc.nextInt();
			
			while(!s.isEmpty()) {
				if(s.peek() > tmp) {	// 새로 넣는 게 작을 때, 그냥 넣기
					sum += s.size();
					s.push(tmp);
					break;
				} else {				// 새로 넣는 게 더 클 땐, 원래 있는 거 빼기
					s.pop();
					if(s.isEmpty()) {	// 빼고 난 뒤에 아무것도 없으면, push
						s.push(tmp);
						break;
					}
				}
			}
			
		}
		
		System.out.println(sum);
		
	}
}
