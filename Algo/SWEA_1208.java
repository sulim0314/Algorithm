package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		
		int[] h = new int[100]; // 각 상자의 높이값
		
		for(int tc=1; tc<=10; tc++) {
			
			int result = 0;
			
			int n = sc.nextInt(); // 덤프 횟수 1 이상 1000 이하 제한값
			
			for(int i=0; i<100; i++) {
				h[i] = sc.nextInt(); // 100개 넣기
			}
			
			Arrays.sort(h);
			
			for(int i=0; i<n; i++) {
				
				h[99] = h[99] - 1;
				h[0] = h[0] + 1;
				
				if((h[99] - h[0] == 0) || (h[99] - h[0] == 1)) {
					result = h[99] - h[0];
					break;
				}
				
				Arrays.sort(h);
				
				result = h[99] - h[0];
				
			}
			
			System.out.println("#"+ tc +" "+ result);
		}
		
		
	}

}
