package com.sulim.study_0823수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_D4_최소스패닝트리_고수림 {


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
	static int A,B,C;
	
	public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        
        for(int tc=1; tc<=T; tc++) {
        	long result = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	V = Integer.parseInt(st.nextToken());
        	E = Integer.parseInt(st.nextToken());
        	
        	edgeList = new Edge[E];
        	
        	for(int i=0; i<E; i++) {
        		st = new StringTokenizer(br.readLine());
        		A = Integer.parseInt(st.nextToken())-1;
        		B = Integer.parseInt(st.nextToken())-1;
        		C = Integer.parseInt(st.nextToken());
        		edgeList[i] = new Edge(A, B, C);
        	}
        	
        	// 간선리스트를 가중치 기준 오름차순 정렬
    		Arrays.sort(edgeList);
    		
    		// V개의 정점으로 make set 작업
    		make();
        	
    		int count = 0;
    		for(Edge edge : edgeList) {
    			if(union(edge.from, edge.to)) {
    				result += edge.weight;
    				if(++count == V-1) break;
    			}
    		}
        	
        	System.out.println("#"+ tc +" "+ result);
        }
        
		
		
	}
	
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

}
