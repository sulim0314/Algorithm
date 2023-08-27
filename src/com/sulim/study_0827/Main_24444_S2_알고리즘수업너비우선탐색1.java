package com.sulim.study_0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_24444_S2_알고리즘수업너비우선탐색1 {

	static int N,M,R;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] order;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		order = new int[N+1];
		visited = new boolean[N+1];
		
		// 간선 정보
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		for(int i=0; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		check(R);
		
		for(int i=1; i<N+1; i++) {
			System.out.println(order[i]);
		}
		
	}

	private static void check(int n) {

		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			order[cur] = cnt++;
			for(int i=0; i<list[cur].size(); i++) {
				int nn = list[cur].get(i);
				if(!visited[nn]) {
					q.add(nn);
					visited[nn] = true;
				}
			}
		}
		
		
		
	}

}
