package com.sulim.study_0904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657_G4_타임머신 {

	static class Edge {
		int s;
		int d;
		int w;
		
		Edge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}
	
	static int N,M;
	static long[] dist;
	static Edge[] edge;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		edge = new Edge[M + 1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int weight = Integer.parseInt(st.nextToken()); 
			
			edge[i] = new Edge(from, to, weight);
		}
		
		dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[1] = 0; // 출발지 비용
		for(int i=1; i<=N+M; i++) {
			for(int j=1; j<=M; j++) {
				if(dist[edge[j].s] == Integer.MAX_VALUE) {
					continue;
				}
				
				if(dist[edge[j].d] > dist[edge[j].s] + edge[j].w) {
					
					dist[edge[j].d] = dist[edge[j].s] + edge[j].w;
					// i 가 N + 1보다 커지면 계속해서 가중치가 지속적으로 작아지는 것 
                    // = 무한히 오래 전으로 되돌릴 수 있음 : -1 출력
					if (i >= N + 1) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("-1"); // 경로 없으니까 -1 출력
			} else {
				System.out.println(dist[i]);
			}
		}
		
		
		
		
	}

}
