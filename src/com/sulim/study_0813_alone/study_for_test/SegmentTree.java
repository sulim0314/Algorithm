package com.sulim.study_0813_alone.study_for_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SegmentTree {

	static long arr[];	// 원소를 저장하는 배열
	static long tree[];	// SGtree
	
	static long init(int node, int start, int end) {
		if(start == end) {	
			return tree[node] = arr[start];	
		} else {
			int mid = (start + end)/2;		
			int nn = node*2; 
			return tree[node] = init(nn, start, mid)+init(nn+1, mid+1, end);
		}
		
	}
	
	static long sum(int node, int start, int end, int left, long right) {
		if(left>end	||	right<start) {	
			return 0;
		}
	
		if(left<=start && end<=right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int nn = node*2;

		return sum(nn, start, mid, left, right) + sum(nn+1, mid+1, end, left, right);
	
	}
	
	public static void update(int node, int start, int end, int index, long diff) {
		// 범위 밖에 있는 경우, 확인 불필요
		if(index<start || index>end) {
			return;
		}
		
		// 범위 내에 있는 node, 차이값을 update
		tree[node] += diff;
		
		//leaf 노드일때
		if(start == end) {
			arr[index] = tree[node];
			return;
		}
		
		// 중간 노드 => 하위 노드도 변경
		int mid = (start + end) / 2;
		int nn = node*2;
		
		update(nn, start, mid, index, diff);
		update(nn+1, mid+1, end, index, diff);
		
		return;
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());		//원소 수
		int M = Integer.parseInt(st.nextToken());		//구간합 구할 횟수
		int K = Integer.parseInt(st.nextToken());		//update 횟수
		
		arr = new long[N];
		tree = new long[N<<2];	// 공간낭비 조금 있음
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		
		init(1, 0, N-1);
		
		for(int i=0, end=M+K; i<end; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(command == 1) {		// 변경
				long diff = b - arr[a-1];
				update(1, 0, N-1, a-1, diff);
			} else {				// sub
				out.write(sum(1, 0, N-1, a-1, (int)b-1) + "\n");
			}
		}
		
		in.close();
		out.close();
		
	}

}

/*
 * 
12 1 0
1
9
3
8
4
5
5
9
10
3
4
5
2 1 4
 * 
 * 
 */
