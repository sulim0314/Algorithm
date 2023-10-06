package com.sulim.study_231005목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_G4_녹색옷입은애가젤다지_고수림 {

	static class Node implements Comparable<Node> {
		int r, c, weight;
		public Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] dist;
	static int N, result;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 0;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) return;
			
			tc++;
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int w = Integer.parseInt(st.nextToken());
					map[i][j] = w;
				}
			}
			
			result = dijk();
			System.out.println("Problem "+tc+": "+result);
		}
		
	}

	private static int dijk() {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] check = new boolean[N][N];
		dist = new int[N][N];
		pq.add(new Node(0, 0, map[0][0]));
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dist[i][j] = INF;
			}
		}
		dist[0][0] = map[0][0];
		
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curR = curNode.r;
			int curC = curNode.c;
			
			if(check[curR][curC] == true) continue;
			check[curR][curC] = true;
			
			// 4방향
			for(int i=0; i<4; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
				if(dist[nr][nc] > curNode.weight + map[nr][nc]) {
					dist[nr][nc] = curNode.weight + map[nr][nc];
					pq.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
			
		}
		
		return dist[N-1][N-1]; ///////////
	}

}
