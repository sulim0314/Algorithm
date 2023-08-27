package com.sulim.study_0827일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_G5_최소비용구하기 {

	static class Node implements Comparable<Node> {
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int N,M;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] check;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); 
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[N];  // 시작점에서 자신으로 오는 최단거리
		check = new boolean[N]; // 방문 처리 리스트
		Arrays.fill(dist, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1; 
			int to = Integer.parseInt(st.nextToken())-1; 
			int weight = Integer.parseInt(st.nextToken()); 
			
			list[from].add(new Node(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1; 
		int end = Integer.parseInt(st.nextToken())-1; 
		
		System.out.println(dijk(start, end));
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
