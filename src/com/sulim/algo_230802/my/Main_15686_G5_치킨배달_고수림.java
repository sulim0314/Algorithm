package com.sulim.algo_230802.my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_15686_G5_치킨배달_고수림 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] house;
	static int[][] chicken;
	static int cnt_house;
	static int cnt_chicken;
	
	static int[] data;
	static int[] num;
	
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {

		// 0은 빈칸, 1은 집, 2는 치킨집

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		house = new int[2*N][2];
		chicken = new int[13][2];
		
		cnt_house = 0;
		cnt_chicken = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a = sc.nextInt();
				map[i][j] = a;
				if(a == 1) {
					house[cnt_house][0] = i;
					house[cnt_house][1] = j;
					cnt_house++;
				} else if(a == 2) {
					chicken[cnt_chicken][0] = i;
					chicken[cnt_chicken][1] = j;
					cnt_chicken++;
				}
			}
		}

		data = new int[cnt_chicken];
		num = new int[M];
		
		for(int i=0; i<cnt_chicken; i++) {
			data[i] = i;
		}
		
		//남길 치킨집 수. cnt_chicken개 에서, M개를 뽑아야함.
		combi(0,0);
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}
	
	private static void combi(int cnt, int start) {
		if(cnt == M) {	// 모두 뽑은 상황
			int sum = 0;
			int sum_count = 0;
			
			// 도시의 치킨거리는 모든 집의 치킨 거리의 합.
			for(int i=0; i<cnt_house; i++) {		// house 배열에서 
				int min = 10000;
				for(int j=0; j<M; j++) {	// chicken 배열에서 
					int tmp = Math.abs(chicken[num[j]][0] - house[i][0]) + Math.abs(chicken[num[j]][1] - house[i][1]);
					min = (min < tmp)? min: tmp; // 거리 짧은 거
				}
				sum += min; // 최단거리 합 구하기
				sum_count++;
			}
			
			list.add(sum);
			
			return;
		}
		
		for(int i=start; i<cnt_chicken; i++) {
			num[cnt] = data[i];
			combi(cnt+1, i+1);
		}
	}
	

}
/* => N, M => 집의개수 2N개 이하, M<치킨집<=13
5 3  
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
*/

/*
5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
*/