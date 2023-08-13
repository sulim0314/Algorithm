package com.sulim.study_0813_alone.study_for_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {

	static int n;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

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
			
			dfs(0);
			System.out.println();
			
			
		}
		
		
	}

	private static void dfs(int cur) {

		visited[cur] = true;			//stack에서 노드를 꺼내올때 방문 처리한다. 
		System.out.printf("%c->",cur+65);
		
		//인접된 노드 확인
		for (int ad = 0; ad < n; ad++) {
			//  인접됐고                     방문하지 않았다면
			if(map[cur][ad] == 1 && !visited[ad]) {
				dfs(ad);				//stack에 넣어서 인접 노드를 방문 
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

A->B->D->E->C->

*/
