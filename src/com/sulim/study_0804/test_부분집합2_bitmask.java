package com.sulim.study_0804;

import java.util.Arrays;

public class test_부분집합2_bitmask {

	static String[] datas = "abcd".split("");
	static int N = datas.length;
	static int[] subset = new int[N];
	
	public static void main(String[] args) {

		for(int i=0, end=1<<N; i<end; i++) {
			
			for(int j=0; j<N; j++) {
				if((i & 1<<j) != 0) { // 1이면 1 넣기. 0000, 0001, 0010, 이런식으로 검사
					subset[j] = 1;
				}
			}

			int k=0;
			for(int s : subset) {
				if(s != 0) {
					System.out.print(datas[k]);
				}
				k++;
			}
			
			System.out.println();
			
			//초기화
			Arrays.fill(subset, 0);
		}
		
		
	}

}
