package day02;

import java.util.Arrays;

public class Q16_PrimeNum {

	public static int[] solution() {
		int[] prime = new int[500];
		int index = 0;
		
		prime[index++] = 2; // prime[0] = 2;
		prime[index++] = 3; // prime[1] = 3; index = 2;
		
		int cnt = 0;
		
		for(int num=5; num<=1000; num+=2) {
			boolean flag = false;
			
			for(int j=1; prime[j]<Math.sqrt(num); j++) {
				cnt++;
				if(num%prime[j] == 0) { // 소수 아닐 때
					flag = true;
					break;
				}
			}//for--
			
			if(!flag) { // 소수일 때
				prime[index++] = num;
				cnt++;
			}
		}//for--
		System.out.println("수행 횟수: "+ cnt);
		return prime;
	}
	
	public static void main(String[] args) {
		int[] a = solution();
		System.out.println(Arrays.toString(a));
	}

}
