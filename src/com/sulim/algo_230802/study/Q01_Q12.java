package com.sulim.algo_230802.study;
import java.util.*;

public class Q01_Q12 {

	static Scanner sc = new Scanner(System.in); 
	
	public static int[] solution(int N, int M) {
		int[][] arr = new int[N][N];
		int[] answer = new int[M];
		
		// 1. arr 만들기
		System.out.print("원하는 표를 작성해주세요 >> ");
		
		for(int i=0; i<N; i++) {
			String[] tmp = sc.nextLine().split(" "); // 1 2 3 4
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		// 2. newArr 만들기 *
		int[][] newArr = new int[N][N];
        newArr[0][0] = arr[0][0];
        
        for (int i = 1; i < N; i++) {
            newArr[0][i] = newArr[0][i-1] + arr[0][i];
            newArr[i][0] = newArr[i-1][0] + arr[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                newArr[i][j] = newArr[i-1][j] + newArr[i][j-1] - newArr[i-1][j-1] + arr[i][j];
            }
        }
		
        // 3. 답 구하기
		System.out.print("원하는 구간을 작성해주세요 >> ");
		for(int i=0; i<M; i++) {
			String[] tmp = sc.nextLine().split(" "); // 2 2 3 4 / 1 1 4 4
			int a = Integer.parseInt(tmp[0])-1; // 1 1 2 3 / 0 0 3 3
			int b = Integer.parseInt(tmp[1])-1;
			int c = Integer.parseInt(tmp[2])-1;
			int d = Integer.parseInt(tmp[3])-1;
			
			if (a == 0 && b == 0) {
			    answer[i] = newArr[c][d];
			} else if (a == 0) {
			    answer[i] = newArr[c][d] - newArr[0][b-1];
			} else if (b == 0) {
			    answer[i] = newArr[c][d] - newArr[a-1][0];
			} else {
			    answer[i] = newArr[c][d] - newArr[a-1][d] - newArr[c][b-1] + newArr[a-1][b-1]; // 원래 식
			}
		}
		
		return answer;	
	} // ---------------------------

	
	public static void main(String[] args) {
		
		System.out.print("표의 크기와 구할 횟수를 입력해주세요 >> "); // 4 3
		String[] nm = sc.nextLine().split(" ");
		
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		System.out.println(Arrays.toString(solution(N,M)));
	}
}
