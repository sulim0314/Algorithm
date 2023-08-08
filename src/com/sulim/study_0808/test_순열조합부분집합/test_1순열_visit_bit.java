package com.sulim.study_0808.test_순열조합부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class test_1순열_visit_bit {

	// nPr
	static int n;
	static int r;
	static int[] data;
	static int[] num;
	static boolean[] visit;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		
		data = new int[n];
		num = new int[r];
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			data[i] = i+1;
		}
		
		per_visit(0);
		per_bit(0,0);
		
		
	}


	private static void per_visit(int cnt) {
		if(cnt == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visit[i]) {
				continue;
			}
			
			num[cnt] = data[i];
			visit[i] = true;
			per_visit(cnt+1);
			visit[i] = false;
		}
		
	}

	private static void per_bit(int cnt, int flag) {
	
		if(cnt == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((flag & 1<<i) != 0) {
				continue;
			}
			num[cnt] = data[i];
			per_bit(cnt+1, flag | 1<< i);
		}
		
		
	}
	
}
