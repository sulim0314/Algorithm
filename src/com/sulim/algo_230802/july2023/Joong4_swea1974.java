package com.sulim.algo_230802.july2023;

import java.util.Scanner;

public class Joong4_swea1974 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt(); // test case 수 입력
		for (int test_case = 1; test_case < test + 1; test_case++) { // test case 만큼 Loop
			int[][] sudozu = new int[9][9];
			int[] sum_cal = new int[9];
			int[] squal = new int[9];
			int sum_line = 0;
			int tf = 0;
			for (int i = 0; i < sudozu[0].length; i++) {
				for (int j = 0; j < sudozu.length; j++) {
					sudozu[i][j] = scan.nextInt();
					sum_line += sudozu[i][j];
					if (j == 8 && tf != 1) {
						// i가 9의 배수가 될 때 = 가로줄 검사
						if (sum_line % 45 != 0) {
							System.out.println("#" + test_case + " 0");
							tf = 1;
							break;
						}
					}
					// 세로줄 검사
					switch (j) {
					case 0:
						sum_cal[0] += sudozu[i][j];
						break;
					case 1:
						sum_cal[1] += sudozu[i][j];
						break;
					case 2:
						sum_cal[2] += sudozu[i][j];
						break;
					case 3:
						sum_cal[3] += sudozu[i][j];
						break;
					case 4:
						sum_cal[4] += sudozu[i][j];
						break;
					case 5:
						sum_cal[5] += sudozu[i][j];
						break;
					case 6:
						sum_cal[6] += sudozu[i][j];
						break;
					case 7:
						sum_cal[7] += sudozu[i][j];
						break;
					case 8:
						sum_cal[8] += sudozu[i][j];
						break;
					}
					// 3x3 박스 처리
					if (i < 3) {
						if (j < 3)
							squal[0] += sudozu[i][j];
						else if (3 <= j && j < 6)
							squal[1] += sudozu[i][j];
						else if (6 <= j && j < 9)
							squal[2] += sudozu[i][j];
					} else if (3 <= i && i < 6) {
						if (j < 3)
							squal[3] += sudozu[i][j];
						else if (3 <= j && j < 6)
							squal[4] += sudozu[i][j];
						else if (6 <= j && j < 9)
							squal[5] += sudozu[i][j];
					} else {
						if (j < 3)
							squal[6] += sudozu[i][j];
						else if (3 <= j && j < 6)
							squal[7] += sudozu[i][j];
						else if (6 <= j && j < 9)
							squal[8] += sudozu[i][j];
					}
				}
			}
			for (int k = 0; k < sum_cal.length; k++) {
				if (sum_cal[k] % 45 != 0 && tf != 1) {
					System.out.println("#" + test_case + " 0");
					tf = 1;
					break;
				}
				if (squal[k] != 45 && tf != 1) {
					System.out.println("#" + test_case + " 0");
					tf = 1;
					break;
				}
			}
			if (tf == 0) {
				System.out.println("#" + test_case + " 1");
			}
		}
	}
}