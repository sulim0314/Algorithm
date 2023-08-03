package com.sulim.study_0803;

import java.util.Arrays;
import java.util.Scanner;

public class per_순열_flag_비트마스킹 {

	static int n;
	static int r;
	static int[]data;
	static int[]num;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		
		data = new int[n];
		num = new int[r];
		
		for(int i=0; i<n; i++) {
			data[i] = i+1;
		}
		
		per_flag_bit(0,0);
		
	}

	private static void per_flag_bit(int cnt, int flag) {

		if(cnt == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((flag & 1<<i) != 0) {	// => flag가 1이면 continue;
				continue;
			}
			num[cnt] = data[i];
			per_flag_bit(cnt+1, flag | 1<<i);
			
		}
		
	}

}
