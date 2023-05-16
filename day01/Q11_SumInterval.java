package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q11_SumInterval {
	static Scanner sc = new Scanner(System.in);
	
	public static int[] solution(int n, int m) {
		
		System.out.print("배열에 저장할 값을 입력하세요 >> ");
		String str = sc.nextLine(); // 5 4 3 2 1
		String[] strArr = str.split(" ");
		int[] intArr = new int[n]; 
		int[] answer = new int[m]; 
		
		for(int i=0; i<strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		
		System.out.print("구간의 시작값, 끝값을 입력하세요 >> ");

		for(int i=0; i<m; i++) {
			
			int sum = 0;
			
			String startEnd = sc.nextLine(); // 1 3
			String[] ansArr = startEnd.split(" ");
			int start = Integer.parseInt(ansArr[0]); // 1
			int end = Integer.parseInt(ansArr[1]); // 3
			
			for(int j=start-1; j<end; j++) {
				sum += intArr[j]; // 12
			}
			
			answer[i] = sum;
		}

		return answer;
	}
	
	public static void main(String[] args) {
		System.out.print("N과 M을 입력하세요 >> ");
		String[] nm = sc.nextLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		int sum[] = solution(N,M);
		
		System.out.println(Arrays.toString(sum));
	}

}
