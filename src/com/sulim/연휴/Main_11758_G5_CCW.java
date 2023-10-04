package com.sulim.연휴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11758_G5_CCW {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a3 = Integer.parseInt(st.nextToken());
		int b3 = Integer.parseInt(st.nextToken());
		
		int ans = (a1*b2 + a2*b3 + a3*b1) - (b1*a2 + b2*a3 + b3*a1);
		
		if(ans>0) {
			System.out.println(1);
		} else if(ans<0) {
			System.out.println(-1);
		} else {
			System.out.println(0);
		}
		
	}

}
