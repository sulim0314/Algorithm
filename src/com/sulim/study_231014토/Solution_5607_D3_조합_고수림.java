package com.sulim.study_231014토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_D3_조합_고수림 {

	static final int mod = 1234567891;
	static int N, R;
	static long result;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			result = nCr(N, R);
			
			System.out.println("#"+tc+" "+result);
		}
		
	}

	private static long nCr(int n, int r) {

		if(r == 0) {
			return 1;
		}
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1]*i % mod;
		}
		
		return (fac[n] * power(fac[r], mod-2) % mod * power(fac[n-r], mod-2) % mod) % mod ;
	}

	private static long power(long x, int y) {

		long res = 1;
		x = x % mod;
		
		while(y > 0) {
			if(y % 2 == 1) {
				res = (res * x) % mod;
			}
			y = y/2;
			x = (x * x) % mod;
		}
		return res;
	}

}
