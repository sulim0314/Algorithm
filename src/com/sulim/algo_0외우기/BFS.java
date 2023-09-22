package com.sulim.algo_0외우기;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	static int n;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {

		bfs(0);
		
	}

	private static void bfs(int cur) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			System.out.printf("%c=>", cur+65);
			visited[cur] = true;
			
			for(int i=0; i<n; i++) {
				if(map[cur][i]==1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
		
		
	}

		

}
