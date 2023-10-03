package com.sulim.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_G5_순열의순서 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int mode = Integer.parseInt(st.nextToken());
		
		int[] result = new int[N]; 		// 결과 배열
		long[] facto = new long[21]; 	// 1부터 20까지 팩토리얼 저장
		facto[0] = 1;
		for(int i=1; i<=20; i++) {
			facto[i] = facto[i-1] * i;
		}
		boolean[] visited = new boolean[21];
		
		if(mode == 1) {
			long order = Long.parseLong(st.nextToken()); // 몇번째 수인지
			
			for(int i=0; i<N; i++) { // result배열에
				for(int j=1; j<=N; j++) { // 1부터 N까지 뭘 넣을지
					
					if(visited[j]) continue;
					
					if(order > facto[N-i-1]) {
						order -= facto[N-i-1];
					} else {
						result[i] = j;
						visited[j] = true;
						break;
 					}
				}
			}
			
			for(int i=0; i<N; i++) {
				sb.append(result[i]+" ");
			}
			
		} else if (mode == 2){
			for(int i=0; i<N; i++) {
				result[i] = Integer.parseInt(st.nextToken()); // 현재 데이터 넣기
			}
			
			long num = 1;
			for(int i=0; i<N; i++) {
				for(int j=1; j<result[i]; j++) {
					if(visited[j]) continue;
					
					num += facto[N-i-1];
				}
				visited[result[i]] = true;
			}
			sb.append(num);
		}
		
		System.out.println(sb.toString());
		
	}

}
