package com.sulim.study_0813_alone.study_for_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	static int n;
	static int[][] map;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n];
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k=0; k<n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			bfs(0);
			System.out.println();
			
			
		}
		
		
	}

	private static void bfs(int cur) {

		Queue<Integer> q = new LinkedList<>();		
		q.offer(cur);
		
		while(!q.isEmpty()) {
			cur =  q.poll();		
			System.out.printf("%c->", cur+65);
			visited[cur] = true;
			for (int ad = 0; ad <n; ad++) {
				if(map[cur][ad] == 1 && !visited[ad]) {
					q.offer(ad);		
					visited[ad] = true;
				}
			}
		}
		
		
	}

}

/*

1
5
0 1 1 0 0
1 0 0 1 1
1 0 0 0 0
0 1 0 0 0
0 1 0 0 0

A->B->C->D->E->

*/