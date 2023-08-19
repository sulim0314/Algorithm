package com.sulim.study_0818;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjList_Api {

	private static boolean visited[];
	private static int N;
	private static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/AdjList.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			int size = N>>2 == 0? 3:N>>2;
			list = new ArrayList[N];
		
			for(int i=0; i<N; i++) {
				list[i] = new ArrayList<>(size); // 인접 정보를 담을 list를 생성
			}
			
			visited = new boolean[N];
			int link = sc.nextInt();			// 인접 데이터 개수
			int node, ad;
			for(int i=0; i<link; i++) {
				node = sc.nextInt();
				ad = sc.nextInt();
				list[node]. add(ad);			// node에 인접정보(ad)를 추가한다.
			}
			
			dfs(0);
			System.out.println();
			
			visited = new boolean[N];
			bfs(0);
			System.out.println();
			
		}
		
		
	}

	private static void bfs(int cur) {

		Queue<Integer> q = new LinkedList<>();
		visited[cur] = true;
		q.add(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			System.out.printf("%c=>", cur+'a');
			
			for (int i = 0, end=list[cur].size(); i<end; i++) {
				int ad = list[cur].get(i); // 인접정보
				if(!visited[ad]) {
					visited[ad] = true;
					q.add(ad);
				}
			}
		}
		
	}

	private static void dfs(int cur) {

		visited[cur] = true;
		System.out.printf("%c=>",cur+'a');
		
		// 인접 정보 확인
		for(int i=0, end=list[cur].size(); i<end; i++) {
			int ad = list[cur].get(i); // 인접된 node의 정보를 추출
			if(!visited[ad]) {
				dfs(ad);
			}
		}
	}

}
