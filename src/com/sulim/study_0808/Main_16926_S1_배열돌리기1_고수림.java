package com.sulim.study_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_S1_배열돌리기1_고수림 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int end = Math.min(n, m)/2;
		
		for(int i=0; i<r; i++) {
			for(int e=0; e<end; e++) {
				int temp = arr[e][e];
				
				// 맨 위 가로
				for(int a=e; a<m-1-e; a++) {
					arr[e][a] = arr[e][a+1];
				}
				
				// 오른쪽 세로
				for(int a=e; a<n-1-e; a++) {
					arr[a][m-1-e] = arr[a+1][m-1-e];
				}
				
				// 맨 아래 가로
				for(int a=m-1-e; a>e; a--) {
					arr[n-1-e][a] = arr[n-1-e][a-1];
				}
				
				// 왼쪽 세로
				for(int a=n-1-e; a>e; a--) {
					arr[a][e] = arr[a-1][e];
				}
				
				arr[e+1][e] = temp;
				
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

		
	}

}

/*
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
*/