package com.sulim.study_0823수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471_G4_게리맨더링_고수림 {

	static int N; // 초기 집합의 개수
	static int parents[];
	
	private static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;	// 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현) // 자기 자신을 root로 표현
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {	// root
			return a;
		}
		return parents[a] = find(parents[a]); // ★
	}
	
	// a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고 true 반환, 아니면 false 반환
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false; 	// 서로의 대표자가 같은 즉, 같은 집합의 상황이므로 union하지 않음.
		}
		// union 처리 (bRoot를 aRoot 아래로 붙이기 !! : 임의로 ..)
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int[] peopleArr;
	static ArrayList<Integer>[] list;
	static int[] data;
	static boolean[] num;
	static int min = Integer.MAX_VALUE;
	
	// main ----------------------------------------------
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		peopleArr = new int[N];
		list = new ArrayList[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			peopleArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
			for(int j=0; j<temp; j++) {
				int t = Integer.parseInt(st.nextToken()) - 1;
				list[i].add(t);
			}
		}
		
		
		data = new int[N];
		num = new boolean[N];
		
		for(int i=0; i<N; i++) {
			data[i] = i;
		}
		
		subset(0,0);
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		System.out.println(min);
		
	}
	
	private static void subset(int cnt, int start) {
		make();
		int sum1 = 0;
		int sum2 = 0;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			if(num[i] == true) {
				for(int a=0; a<list[i].size(); a++) {
					int ad = list[i].get(a);
					if(num[ad]) {
						union(i, ad);
					}
				}
				count++;
			} else {
				for(int a=0; a<list[i].size(); a++) {
					int ad = list[i].get(a);
					if(!num[ad]) {
						union(i, ad);
					}
				}
			}
		}
		
		if(0<count && count<N) {
			int bit = 0;
			for(int i=0; i<N; i++) {
				bit = bit | (1 << find(i));
			}
			
			if(Integer.bitCount(bit) == 2) {
				for(int i=0; i<N; i++) {
					if(num[i] == true) {
						sum1 += peopleArr[i];
					} else {
						sum2 += peopleArr[i];
					}
				}
				min = Math.min(min, Math.abs(sum1 - sum2));
			} 
		}
		
		
		for(int i=start; i<N; i++) {
			num[data[i]] = true;
			subset(cnt+1,i+1);
			num[data[i]] = false;
		}
		
		
	}

}
