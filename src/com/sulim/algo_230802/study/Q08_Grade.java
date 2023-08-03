package com.sulim.algo_230802.study;
import java.util.*;
public class Q08_Grade { // 등수 구하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요 >> ");
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] gradeArr = new int[n];
		
		System.out.println("국어 성적 "+ n +"개 입력");
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt(); // 78 82 65 82 100 
			arr2[i] = arr1[i];
		}
		
		Arrays.sort(arr2); // 65 78 82 82 100
		
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				if(arr1[i] == arr2[j]) {
					gradeArr[i] = n - j;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(gradeArr)); // 4 2 5 2 1

	}
}
