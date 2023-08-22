package com.sulim.study_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_D4_서로소집합_고수림 {

	static int M, N;
	static int parents[];
	
	private static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make();
			
			System.out.print("#"+tc+" ");
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				// 합집합
				if(tmp == 0) {
					union(a,b);
					// 같은 집합에 포함되어 있는가	
				} else if(tmp == 1) {
					int aa = find(a);
					int bb = find(b);
					if(aa == bb) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
				
			}
			System.out.println();
		}
		
		
	}

}
