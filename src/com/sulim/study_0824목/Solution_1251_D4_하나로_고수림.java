package com.sulim.study_0824목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_D4_하나로_고수림 {

	static class Vertex implements Comparable<Vertex> {
		int no;
		long weight;
		public Vertex(int no, long weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
	
	static int N;
	static double E;
	static int[] xArr, yArr;
	static ArrayList<Vertex>[] list;
	
	// N개중에 2개 뽑아서 연결해주기 조합
	static int[] data;
	static int[] num;
	
	public static void main(String[] args) throws Exception {

		// 환경부담금 : 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
		// 64비트 integer 및 double로 처리하지 않을 경우, overflow가 발생할 수 있습니다
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
		
        for(int tc=1; tc<=T; tc++) {
        	
        	long result = 0;
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	xArr = new int[N];
        	yArr = new int[N];
        	list = new ArrayList[N];
        	
        	for(int i=0; i<N; i++) {
				list[i] = new ArrayList<>(); 
			}
        	
        	// 길이 L 계산하기 위해 만든 배열들
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) {
        		xArr[i] = Integer.parseInt(st.nextToken());
        	}
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) {
        		yArr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	// 실수 받아오기
        	E = Double.parseDouble(br.readLine());
        	
        	// N개중에 2개 뽑아서 연결해주기
        	data = new int[N];
        	num = new int[2];
        	for(int i=0; i<N; i++) {
        		data[i] = i;
        	}
        	combi(0,0);

        	boolean[] visited = new boolean[N];
        	long[] minEdge = new long[N];
        	PriorityQueue<Vertex> pQ = new PriorityQueue<>();
        	
        	Arrays.fill(minEdge, Long.MAX_VALUE);
        	minEdge[0] = 0;
        	pQ.offer(new Vertex(0, minEdge[0]));
        	
    		long min = 0;
    		int minVertex = 0, cnt = 0;
        	
    		while(!pQ.isEmpty()) {

    			// step1: 미방문(비트리) 정점 중 최소간선비용의 정점을 선택
    			Vertex cur = pQ.poll();
    			minVertex = cur.no;
    			min = cur.weight;
    			if(visited[minVertex]) continue;
    			
    			// step2 : 방문(트리) 정점에 추가
    			visited[minVertex] = true; // 방문 처리
    			result += min; // 신장트리 비용 누적
    			if(++cnt == N) break;
    			
    			// step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선 비용 고려(a.k.a 영업타임)
    			for(int i=0; i<list[minVertex].size(); i++) {
    				if(!visited[list[minVertex].get(i).no] && list[minVertex].get(i).weight < minEdge[list[minVertex].get(i).no]) {
    					minEdge[list[minVertex].get(i).no] = list[minVertex].get(i).weight;
    					pQ.offer(new Vertex(list[minVertex].get(i).no, minEdge[list[minVertex].get(i).no]));
    				}
    				
    			}
    			
    		}   	

    		// E곱해준거로 출력해야됨
    		// 소수 첫째 자리에서 반올림...
    		result = (long) Math.round(E * result) ;
    		
    		System.out.println("#"+tc+" "+result);
        	
        	
        }// 출력
		
		
	}

	private static void combi(int cnt, int start) {
		
		if(cnt == 2) {
			long weight = (long) ((long)(xArr[num[0]]-xArr[num[1]]))*((long)(xArr[num[0]]-xArr[num[1]])) + ((long) (yArr[num[0]]-yArr[num[1]]))*((long) (yArr[num[0]]-yArr[num[1]]));
    		
    		list[num[0]].add(new Vertex(num[1], weight));
    		list[num[1]].add(new Vertex(num[0], weight));
    		
    		return;
		}
		
		for(int i=start; i<N; i++) {
			num[cnt] = data[i];
			combi(cnt+1, i+1);
		}
		
	}

}
