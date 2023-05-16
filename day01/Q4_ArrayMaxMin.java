package day01;

import java.util.Scanner;

public class Q4_ArrayMaxMin {
	
	//최대, 최소값을 배열에 담아서 반환하세요
	public static int[] solution(int [] heights) {
		int[] answer = new int[2]; //최대키, 최소키값을 저장할 배열
		int max = heights[0];
		int min = heights[0];
		
		for(int i=1; i<heights.length; i++) {
			if(heights[i] > max) {
				max = heights[i];
			} else if(heights[i] < min){
				min = heights[i];
			}
		}
		answer[0] = max;
		answer[1] = min;
	
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사람수를 입력하세요 [키의 최대, 최소값을 구합니다] >> ");
		int num = sc.nextInt();
		int[] heights = new int[num];
		
		for(int i=0; i<num; i++) {
			heights[i] = sc.nextInt();
			System.out.println("heights["+ i +"] : " + heights[i]);
		}

		System.out.println("제일 큰 키 : " + solution(heights)[0]);
		System.out.println("제일 작은 키: " + solution(heights)[1]);
	}
}
