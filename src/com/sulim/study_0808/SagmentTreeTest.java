package com.sulim.study_0808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SagmentTreeTest {

	static long arr[];	// 원소를 저장하는 배열
	static long tree[];	// SGtree
	
	/**
	 * 원소를 이용해서 SGTree를 구성하는 함수
	 * @param node		Tree의 node 번호
	 * @param start		원소가 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 시작 index
	 * @param end		원소가 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index
	 * @return			node의 저장된 값을 리턴한다. 	단말 노드면 원소이 값이고, 중간 노드면 관리하고 있는 중간 값.
	 */
	static long init(int node, int start, int end) {
		if(start == end) {	// 단말 노드
			return tree[node] = arr[start];	// 원소의 값을 노드에 저장한다.
		} else {
			// 하위 노드의 값을 더해서 저장
			int mid = (start + end)/2;		//	int mid = (start + end)>>1; 랑 똑같음
			int nn = node*2; 
			return tree[node] = init(nn, start, mid)+init(nn+1, mid+1, end);
		}
		
	}
	
	/**
	 * 구간 합을 구하는 함수
	 * @param node		Tree의 node 번호
	 * @param start		원소가 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 시작 index
	 * @param end		원소가 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index		
	 * @param left		구간합을 구할 start index
	 * @param right		구간합을 구할 end index
	 * @return			arr의 index가 구간합을 구할 index의 범위 밖이면 0을 리턴하고
	 * 					범위 내의 index인 경우 단말 노드면 원소 값을 리턴하고
	 * 					중간 노드면 하위 노드를 sum한 값을 리턴한다.
	 */
	static long sum(int node, int start, int end, int left, long right) {
		if(left>end	||	right<start) {	// 구간 합을 구할 범위 밖
			return 0;
		}
		// start~end는 구간 합을 구할 범위 내에 속하는 원소 
	
		// 단말 노드 라면
		if(left<=start && end<=right) {
			return tree[node];
		}
		
		// 하위 노드의 sum 값을 구한다.
		int mid = (start+end)/2;
		int nn = node*2;
//				 왼쪽 하위 노드
		return sum(nn, start, mid, left, right) + sum(nn+1, mid+1, end, left, right);
	
	}
	
	/**
	 * index번째 데이터 값을 변경하기
	 * @param node		Tree의 node 번호
	 * @param start		원소가 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 시작 index
	 * @param end		원소가 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index		
	 * @param index		변경할 원소의 index
	 * @param diff		원소와 변경할 데이터의 차이값
	 * @return
	 */
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
	
	
	public static void main(String[] args) throws IOException {
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
