package com.sulim.study_231004수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 참고 사이트 : 
 * https://littlefoxdiary.tistory.com/10
 * https://www.secmem.org/blog/2019/12/15/RabinKarpCollision/
 * 
 * 시간 복잡도  (N-k+1)*k   => O(N*k) 
 */
public class RabinKarpTest_강의 {
	public static void main(String[] args) 	throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		if(tlen <plen) {
			System.out.println(0);
		}else {
			final int base = 26;
			final int MOD = 1000000007;		// base^plen-1 이 값이 너무 커서   해쉬값을  소수로 모듈레이션 한다.
			
			long power = 1;
			long thash = 0;
			long phash = 0;
			
			//슬라이딩 위도우 기법을 이용
			//첫 윈도우 값 구하기 
			for (int i = 0; i < plen; i++) {
				phash = (phash * base + pattern[i]) %MOD;
				thash = (thash * base + text[i]) %MOD;
				if(i !=0) power = (power*base) %MOD;		//다음 윈도우로 이동시 첫번째 데이타를 제거하기 위한 
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0, end = tlen - plen; i <=end; i++) {
				if(phash == thash) {
					list.add(i);
				}
				
				if(i+plen==tlen) break;
//			       다음 윈도우로 이동하기 위해 첫번째 부분 제거                         윈도우에 새로운 데이타 추가
				thash =   ((thash - text[i]*power) * base + text[i+plen]) % MOD;
				if(thash < 0) thash += MOD;
			}
			
			System.out.println(list.size());
			for (Integer idx : list) {
				System.out.printf("%d ", idx);
			}
		}
	}
}
