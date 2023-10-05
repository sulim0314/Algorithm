package com.sulim.study_231004수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * KMP (Knuth-Morris-Pratt Algorithm)     O(N+M)
 * - 모든 문자열을 패턴과 비교하지 않고  패턴과 일치하는 문자열을 찾을 수 있는 알고리즘
 * - 접두자와 접미자의 개념을 활용해서 '반복되는 연산을 얼마나 줄일 수 있는지(fail함수 이용)'를 판변ㄹ하여 
 *   매칭할 문자열을 빠르게 점프하는 기법. 
 *   => fail함수 : 접두사와 접미사가 일치하는 최대 길을 계산 => 동일한 부분을 다시 비교하지 않도록 점프
 *   
 *   
 *  1. P[i] 구하기
 *     1.1  i=1, j=0으로 시작
 *     1.2  i와 j 위치의 문자를 비교해서 
 *          일치 하지 않으면   j=p[j-1]로 이동해서 계속 비교, ==> 일치하거나, j>0까지 비교
 *          일치 하면  p[i] = ++j, i를증가시키고  => 결국 i와 j가 증가한다.
 * 
 *  2. 본문과 pattern 비교하기 
 *    2.1   i=0(본문), j=0(패턴)으로 시작
 *    2.2   i와 j 위치의 문자를 비교해서
 *          일치 하지 않으면   j=p[j-1]로 이동해서 계속 비교, ==> 일치하거나, j>0까지 비교
 *          일치 하면  
 *            2.2.1 j가 패턴의 끝이면     ==> 본문에서 패턴과 일치하는 문자를 발견 함
 *            2.2.2 끝이 아니면  j만 증가  
 */
public class KMPTest_강의 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//본문
		char[] text = in.readLine().toCharArray();
		//pattern
		char[] pattern = in.readLine().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		//실패시 점프할 위치를 위한 접두사와 접미가 동일한 길을 저장
		int[] p= new int[plen];
//		1. P[i] 구하기                    
//		   1.1  i=1, j=0으로 시작                                              
		for(int i=1, j=0; i<plen; i++) {
//		   1.2  i와 j 위치의 문자를 비교해서
//		        일치 하지 않으면   j=p[j-1]로 이동해서 계속 비교, ==> 일치하거나, j>0까지 비교
			while(j>0 && pattern[i] != pattern[j]) {
				j=p[j-1];
			}
			
//		        일치 하면  p[i] = ++j, i를증가시키고  => 결국 i와 j가 증가한다.
			if(pattern[i]==pattern[j]) p[i] = ++j;
		}
		System.out.println(Arrays.toString(p));
		
		int cnt = 0;			//패턴과 일치하는 본문의 문자 개수
		ArrayList<Integer> list = new ArrayList<Integer>();
//		2. 본문과 pattern 비교하기                                                
//		  2.1   i=0(본문), j=0(패턴)으로 시작
		for(int i=0, j=0; i<tlen; i++) {
//		  2.2   i와 j 위치의 문자를 비교해서                                          
//		        일치 하지 않으면   j=p[j-1]로 이동해서 계속 비교, ==> 일치하거나, j>0까지 비교
			while( j>0 && text[i] != pattern[j] ) j = p[j-1];
//		        일치 하면                                                      
			if(text[i] == pattern[j]) {
//		          2.2.1 j가 패턴의 끝이면     ==> 본문에서 패턴과 일치하는 문자를 발견 함
				if(j== plen-1) {
					cnt++;
					list.add(i-plen+1); //패턴이 일치하는 본문의 시작 위치
					j = p[j];
				}else {
//		          2.2.2 끝이 아니면  j만 증가 , i는 for문에서 증가 시키기 때문
					j++;
				}
			}
		}
		System.out.println("일치한 개수 :"+cnt);
		if(cnt>0) {
			for (Integer idx : list) {
				System.out.printf("%d ",idx);
			}
		}
	}
}







