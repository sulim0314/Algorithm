package com.sulim.study_0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class e_xy {
	int x, y;

	public e_xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Main_17135_G3_캐슬디펜스_고수림 {

	static int N, M, D;
	static int[][] map;
	static int[][] map_og;
	static int[] castle;
	static int max;
	static ArrayList<e_xy> list;
	static ArrayList<e_xy> list_123;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		map_og = new int[N + 1][M];
		castle = new int[3];
		max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map_og[i][j] = temp;
			}
		}

		combi(0, 0);

		System.out.println(max);

	}

	private static void combi(int cnt, int start) {

		if (cnt == 3) {
			list = new ArrayList<>();
			mapCopy();
			att(N, castle);
			max = Math.max(max, list.size());
			return;
		}

		for (int i = start; i < M; i++) {
			castle[cnt] = i;
			combi(cnt + 1, i + 1);
		}

	}

	private static void mapCopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map_og[i][j];
			}
		}
	}

	// 맨처음 성의 위치
	// map[N][cs_arr[0]], map[N][cs_arr[1]], map[N][cs_arr[2]]
	private static void att(int cs_x, int[] cs_arr) {
		list_123 = new ArrayList<>(); // 한 turn에 궁수 3명이 쏠 적들

		for (int cs = 0; cs < 3; cs++) {
			// 궁수랑 위치가 똑같으면
			if (map[cs_x][cs_arr[cs]] == 1) {
				map[cs_x][cs_arr[cs]] = 0;
			}
		}
		// 궁수1부터 궁수3까지 공격 시작
		for (int cs=0; cs<3; cs++) {
			// 제일 가까운곳부터, 왼쪽부터 공격.
			top: 
			for (int d=1; d<=D; d++) {
				// 왼쪽부터
				for (int j=cs_arr[cs]-d; j<=cs_arr[cs]+d; j++) {
					// 밑부터(성 위쪽부터)
					for (int i=cs_x-1; i>=cs_x-d; i--) {

						if (0<=i && i<N && 0<=j && j<M) {
							// 거리가 d일때
							if (Math.abs(cs_x-i) + Math.abs(cs_arr[cs]-j) == d) {
								// 가장 왼쪽에 있는곳부터 확인하는데 적이 있다면 list 넣고 바로 나가기
								if (map[i][j] == 1) {
									list_123.add(new e_xy(i, j));
									break top;
								}
							}
						}
					}
				}
			} // top
		} // 첫번째부터 세번째까지
		// 3명 다 확인하고 죽여야됨..
		check();

		// cs 행이 0이 되면
		if (cs_x == 0) {
			return;
		}
		
		// 성 앞으로
		att(cs_x - 1, cs_arr);
	}

	private static void check() {
		for (int i = 0; i < list_123.size(); i++) {
			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).x == list_123.get(i).x && list.get(j).y == list_123.get(i).y) {
					flag = true;
					break;
				}
			}
			// list에 없으면 (안죽였으면)
			if (!flag) {
				list.add(new e_xy(list_123.get(i).x, list_123.get(i).y));
				map[list_123.get(i).x][list_123.get(i).y] = 0;
			}
		}
	}

}
