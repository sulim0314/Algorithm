package com.sulim.study_0807;

import java.util.Arrays;
import java.util.Scanner;

public class per_순열_visit {

	static int n;
	static int r;
	static boolean[] visit;
	static int[]data;
	static int[]num;
	
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

}
