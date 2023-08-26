package com.sulim.study_0823수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 1. make()					=> 시간 복잡도 V
 * 2. Edge 정렬(merge sort)		=> 시간 복잡도 EdgeE
 * 3. union						=> 시간 복잡도....
 *
 */
public class MSTKruskalTest { // 모든 정점들을 가장 적은 수의 간선&비용으로 연결하는것

	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static Edge[] edgeList;
	static int V,E;
	static int[] parents;
	
	static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 싸이클 발생 의미로 해석됨 !
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		// 간선리스트를 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		// V개의 정점으로 make set 작업
		make();
		
		int result = 0;
		int count = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}

}
