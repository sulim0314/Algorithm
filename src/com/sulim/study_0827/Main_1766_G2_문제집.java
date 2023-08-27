package com.sulim.study_0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766_G2_문제집 {

	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] num;
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		num = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			num[to]++;
		}
		
		sort();
		
	}

	private static void sort() {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		// 선행노드가 없는 애들 넣어주기
		for(int i=1; i<N+1; i++) {
			if(num[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			System.out.print(n+" ");
			
			for(int i=0; i<list[n].size(); i++) {
				int x = list[n].get(i);
				num[x]--;
				if(num[x] == 0) {
					q.add(x);
				}
			}
			
		}
		
			
		
	}

}
