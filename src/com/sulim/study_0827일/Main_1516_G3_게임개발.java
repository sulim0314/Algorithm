package com.sulim.study_0827일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1516_G3_게임개발 {

	static int N;
	static ArrayList<Integer>[] list;
	static int[] time, memo;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 건물의 종류 수
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		time = new int[N+1];
		memo = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			
			while(true) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == -1) break;
				list[i].add(temp);
			}
		}
		
        for (int i = 1; i <= N; i++) {
            System.out.println(check(i));
        }
	
	}

	private static int check(int num) {

		if(memo[num] != 0) {
			return memo[num];
		}
		
		int maxTime = 0;
		for(int i=0; i<list[num].size(); i++) {
			maxTime = Math.max(maxTime, check(list[num].get(i)));
		}
		
		return memo[num] = time[num] + maxTime;
	}

}











