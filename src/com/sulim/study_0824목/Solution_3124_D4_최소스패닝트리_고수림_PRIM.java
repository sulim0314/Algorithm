package com.sulim.study_0824목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_D4_최소스패닝트리_고수림_PRIM {

	static class Vertex implements Comparable<Vertex> {
		int no, weight;
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        
        for(int tc=1; tc<=T; tc++) {
        	
        	st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	ArrayList<Vertex>[] list = new ArrayList[V];
        	
        	for(int i=0; i<V; i++) {
				list[i] = new ArrayList<>(); 
			}
        	
        	for(int i=0; i<E; i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken())-1;
        		int to = Integer.parseInt(st.nextToken())-1;
        		int weight = Integer.parseInt(st.nextToken());
        		
        		list[from].add(new Vertex(to, weight));
        		list[to].add(new Vertex(from, weight));
        	}
        	
        	boolean[] visited = new boolean[V];
        	int[] minEdge = new int[V];
        	PriorityQueue<Vertex> pQ = new PriorityQueue<>();
        	
        	Arrays.fill(minEdge, Integer.MAX_VALUE);
        	minEdge[0] = 0;
        	pQ.offer(new Vertex(0, minEdge[0]));
        	
        	long result = 0;
    		int min = 0, minVertex = 0, cnt = 0;
        	
    		while(!pQ.isEmpty()) {

    			// step1: 미방문(비트리) 정점 중 최소간선비용의 정점을 선택
    			Vertex cur = pQ.poll();
    			minVertex = cur.no;
    			min = cur.weight;
    			if(visited[minVertex]) continue;
    			
    			// step2 : 방문(트리) 정점에 추가
    			visited[minVertex] = true; // 방문 처리
    			result += min; // 신장트리 비용 누적
    			if(++cnt == V) break;
    			
    			// step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선 비용 고려(a.k.a 영업타임)
    			for(int i=0; i<list[minVertex].size(); i++) {
    				if(!visited[list[minVertex].get(i).no] && list[minVertex].get(i).weight < minEdge[list[minVertex].get(i).no]) {
    					minEdge[list[minVertex].get(i).no] = list[minVertex].get(i).weight;
    					pQ.offer(new Vertex(list[minVertex].get(i).no, minEdge[list[minVertex].get(i).no]));
    				}
    				
    			}
    			
    		}   	

    		System.out.println("#"+tc+" "+result);
        	
        }
        
		
		
	}

}
