package com.sulim.study_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_고수림 {

	static int N;
	static int M;
	static int[] arr;
	static int result;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test_case = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=test_case; tc++) {
			result = -1;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// N개 중에서 2개 뽑기 nCr -> 합이 M을 초과하지 않게.
			check(0,0,0);
			
			System.out.println("#"+tc+" "+ result);
		}
		
		br.close();
		
	}

	private static void check(int cnt, int start, int sum) {
		
		if(cnt == 2) {
			if(sum <= M) {
                result = Math.max(result, sum);
            }
			return;
		}
		
		for(int i=start; i<N; i++) {
			check(cnt+1, i+1, sum+arr[i]);
		}
		
	}

}

/* 입력
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16
*/

/* 출력
#1 40
#2 10
#3 -1
#4 20
*/
