package com.sulim.study_0816.group;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1929_S3_소수구하기_스터디 {

	static int M;
	static int N;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		

		for(int i=M; i<=N; i++) {
			flag = true;
			check(i);
			if(flag && i!=1) {
				bw.write(i+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		
	}

	private static void check(int num) {

		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) { // 소수가 아닌거
				flag = false;
				break;
			} 
		}
		
	}

}
