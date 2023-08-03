package com.sulim.algo_230802.july2023;
import java.util.Arrays;
import java.util.Scanner;

public class SwitchTest {
   public static void main(String[] args) {
      // o: off , 1: on , 초기: 모두 off
      // N, M입력 (N: 스위치 개수 // M: 입력값의 배수의 자리 스위치 변화)

//      switch: 1 2 3 4 5 6 7 8 9 10
//      배열        : 0 1 2 3 4 5 6 7 8 9
//      초기        : 0 0 0 0 0 0 0 0 0 0
//      M=3   : 0 1 1 1 1 0 0 1 1 0
//      M(3,5,2) -> switch 3,9,5,2,4,8 (6, 10은 2번 중복)
      
      Scanner sc = new Scanner(System.in);
      
      // N, M 입력하기 (M 입력 후 갯수만큼 한번 더 입력하기)
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] M_arr = new int[M];
      
      // arr 0 초기화 스위치 배열 생성
      int[] arr = new int[N]; // 0 0 0 0 0 0 0 0 0 0 0
      
      for(int i=0; i < M; i++) {
         M_arr[i] = sc.nextInt(); // 3 5 2
      }
    
      
      for(int i=0; i<M_arr.length; i++) { // 3 5 2
    	  
    	  for(int j=0; j<N-1; j++) { // 10번 확인
    		  
    		  if((j+1) % M_arr[i] == 0) {	// 3이나 5나 2로 나누어 떨어질 때
    			  
        		  if(arr[j] == 0) { 	// 0이면 1로 바꿔주기
        			  arr[j] = 1;
        		  } else if (arr[j] != 0) {	// 1이면 0으로 바꿔주기
        			  arr[j] = 0;
        		  }
        		  
        	  }
    		  
    	  }
    	  
      }
      
      
      
      System.out.println(Arrays.toString(arr));
      System.out.println(N);
      System.out.println(Arrays.toString(M_arr));
      
      
      
   }
}