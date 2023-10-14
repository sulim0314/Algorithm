package com.sulim.study_231014토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458_D4_원점으로집합_고수림 {

	static long result;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int a = 0;
			int b = 0;
			long max = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				long x = Long.parseLong(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				long xySum = Math.abs(x) + Math.abs(y);
				max = Math.max(xySum, max);
				if(xySum%2 == 1) {
					a = 1;
				} else {
					b = 1;
				}
			}
			int idx = 0;
			if(a+b == 1) { // 계산 가능
				if(a == 1) {
					long sum = 0;
					while(true) {
						sum += idx;
						if(max <= sum && sum%2 == 1) {
							result = idx;
							break;
						}
						idx++;
					}
				} else {
					long sum = 0;
					while(true) {
						sum += idx;
						if(max <= sum && sum%2 == 0) {
							result = idx;
							break;
						}
						idx++;
					}
				}
				sb.append("#").append(tc).append(" ").append(result).append("\n");
			} else {
				sb.append("#").append(tc).append(" ").append("-1\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
