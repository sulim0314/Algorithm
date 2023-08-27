package com.sulim.study_0827일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_G4_특정한최단경로_다익스트라 {

	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] check;
	static final int INF = 200000000;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		
		list = new ArrayList[V];
		for(int i=0; i<V; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[V];  // 시작점에서 자신으로 오는 최단거리
		check = new boolean[V]; // 방문 처리 리스트
		Arrays.fill(dist, INF);
		
		// 양방향 인접리스트 구현
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		// 반드시 거쳐야 하는 정점 받아오기
		st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		
		// 0-1, 1-2, 2-3 확인
		int res1 = 0;
		res1 += dijk(0,a);
		res1 += dijk(a,b);
		res1 += dijk(b,V-1);
		
		// 0-2, 2-1, 1-3 확인
		int res2 = 0;
		res2 += dijk(0,b);
		res2 += dijk(b,a);
		res2 += dijk(a,V-1);
		
		int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
		
		System.out.println(ans);
		
		
	}

	private static int dijk(int start, int end) {

		Arrays.fill(dist, INF);
        Arrays.fill(check, false);
		
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
        	Node curNode = pq.poll();
        	int cur = curNode.end;
        	
        	if(!check[cur]) {
        		check[cur] = true;
        		
        		for(Node node : list[cur]) {
        			if(!check[node.end] && dist[node.end]>dist[cur]+node.weight) {
        				dist[node.end] = dist[cur] + node.weight;
        				pq.add(new Node(node.end, dist[node.end]));
        			}
        		}
        	}
        }
		
		return dist[end];
	}

}