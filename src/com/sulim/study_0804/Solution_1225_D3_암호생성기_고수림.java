package com.sulim.study_0804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_D3_암호생성기_고수림 {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<>();

		Scanner sc = new Scanner(System.in);

		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			
			for(int i=0; i<8; i++) {
				q.add(sc.nextInt());
			}
			
			int num=1;
			
			while(true) {
				int tmp = q.poll()-(num % 6);
				if(tmp <= 0) {
					q.add(0);
					System.out.print("#"+tc+" ");
					for(int i=0; i<8; i++) {
						System.out.print(q.poll()+" ");
					}
					break;
				}
				q.add(tmp);
				num++;
				if(num == 6) {
					num = 1;
				}
			}
			System.out.println();
		}
		
	}

}

