package com.sulim.algo_0외우기;

import java.util.Arrays;

public class DisjointSetTest {

	static int N; // 초기 집합의 개수
	static int parents[];
	
	private static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;	// 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현)
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
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
	
	// main ----------------------------------------------
	public static void main(String[] args) {
		
		N = 5;
		make();
		
		System.out.println(Arrays.toString(parents)); // [0, 1, 2, 3, 4]
		
		System.out.println(union(0,1)); // true
		System.out.println(Arrays.toString(parents)); // [0, 0, 2, 3, 4]

		System.out.println(union(2,1));	// true
		System.out.println(Arrays.toString(parents)); // [2, 0, 2, 3, 4]
		
		System.out.println(union(3,2));	// true
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 3, 4]
		
		System.out.println(union(4,3));	// true
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 4, 4]
		
		System.out.println("================ find ================");
		
		System.out.println(find(4));	// 4
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 4, 4]
		System.out.println(find(3));	// 4
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 4, 4]
		System.out.println(find(2));	// 4
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 4, 4]
		System.out.println(find(0));	// 4
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 4, 4]
		System.out.println(find(1));	// 4
		System.out.println(Arrays.toString(parents)); // [2, 0, 3, 4, 4]
		
		
	}
	
}
