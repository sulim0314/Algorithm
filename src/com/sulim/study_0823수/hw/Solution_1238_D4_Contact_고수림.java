package com.sulim.study_0823수.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_D4_Contact_고수림 {
 
	static int N;
	static ArrayList<Integer>[] list;
	static int visited[];
	static int maxLv, maxNum;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			
			for(int i=0; i<101; i++) {
				list[i] = new ArrayList<>(); 
			}
			
			int from, to;
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N/2; n++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			
			visited = new int[101];
			
			maxLv = -1;
			maxNum = -1;
			
			bfs(first);
			
			for(int i=0; i<101; i++) {
				if(visited[i] == maxLv) {
					maxNum = Math.max(maxNum, i);
				}
			}
			
			System.out.println("#"+tc+" "+ maxNum);
		}
	
	}

	private static void bfs(int cur) {
		
		Queue<Integer> q = new LinkedList<>();
		visited[cur] = 1;
		q.add(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i=0; i<list[cur].size(); i++) {
				int ad = list[cur].get(i);
				if(visited[ad] > 0) {
					continue;
				}
				
				q.add(ad);
				visited[ad] = visited[cur] + 1;
				maxLv = Math.max(maxLv,visited[ad]);
			}
		}
		
	}

}

/*
24 2
2 7 11 6 6 2 2 15 15 4 4 2 4 10 7 1 1 7 1 8 1 17 3 22
*/
