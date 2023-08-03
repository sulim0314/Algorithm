package com.sulim.algo_230802.july2023;

import java.util.Scanner;

//A와 B가 가위바위보를 하였다.
//가위는 1, 바위는 2, 보는 3으로 표현되며 A와 B가 무엇을 냈는지 입력으로 주어진다.
//A와 B중에 누가 이겼는지 판별해보자. 단, 비기는 경우는 없다.
//[입력]
//입력으로 A와 B가 무엇을 냈는지 빈 칸을 사이로 주어진다.
//[출력]
//A가 이기면 A, B가 이기면 B를 출력한다.

public class ha1 {

	public static void main(String[] args) {
		String winner = "";
		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
			winner = "A";
		} else {
			winner = "B";
		}

		System.out.println(winner);

	}

}
