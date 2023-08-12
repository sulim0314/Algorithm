package com.sulim.study_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1370_G5_회의실배정_고수림 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]); // 종료시간 기준 오름차순으로.
		
		list.add(arr[0][0]);
		
		int temp = arr[0][2];
		
		for(int i=1; i<N; i++) {
			if(temp <= arr[i][1]) {
				list.add(arr[i][0]);
				temp = arr[i][2];
			}
			if(temp == arr[arr.length-1][2]) {
				break;
			}
		}
		
		
		System.out.println(list.size());

		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

}

/*
6
1 1 10
2 5 6
3 13 15
4 14 17
5 8 14
6 3 12
*/