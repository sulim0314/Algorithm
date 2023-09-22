package com.sulim.algo_0외우기;

public class DFS {

	static int n;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		dfs(0);
		
	}

	private static void dfs(int cur) {

		visited[cur] = true;
		System.out.printf("%c -> ", cur+65);
		
		for(int i=0; i<n; i++) {
			if(map[cur][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
		
		
	}

	
}

