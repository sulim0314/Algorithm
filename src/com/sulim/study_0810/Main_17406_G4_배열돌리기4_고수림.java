package com.sulim.study_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_G4_배열돌리기4_고수림 {

	static int N, M, K;
	static int[][] map;
	static int[][] map2;
	static int[][] forPermutation;
	static int[] data;
	static int[] num;
	static boolean[] visit;
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		map2 = new int[N + 1][M + 1];
		data = new int[K];
		num = new int[K];
		visit = new boolean[K];
		forPermutation = new int[K][3];
		min = 100000000;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			forPermutation[i][0] = Integer.parseInt(st.nextToken());
			forPermutation[i][1] = Integer.parseInt(st.nextToken());
			forPermutation[i][2] = Integer.parseInt(st.nextToken());
			data[i] = i;
		}

		per(0);

		System.out.println(min);

	}

	// 회전연산 순열
	private static void per(int cnt) {

		if (cnt == K) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					map2[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < K; i++) {
				rotate(forPermutation[num[i]][0], forPermutation[num[i]][1], forPermutation[num[i]][2]);
			}
			calculate(); // 최소값 갱신

			return;
		}

		for (int i = 0; i < K; i++) {
			if (visit[i]) {
				continue;
			}
			num[cnt] = data[i];
			visit[i] = true;
			per(cnt + 1);
			visit[i] = false;
		}

	}

	// map[x][y]를 중심으로 범위 range로 회전하기
	private static void rotate(int x, int y, int range) {
		while (range > 0) {
            int temp = map2[x - range][y - range];

            // 왼쪽 세로
            for (int a = x - range; a < x + range; a++) {
                map2[a][y - range] = map2[a + 1][y - range];
            }

            // 아래 가로
            for (int a = y - range; a < y + range; a++) {
                map2[x + range][a] = map2[x + range][a + 1];
            }

            // 오른쪽 세로
            for (int a = x + range; a > x - range; a--) {
                map2[a][y + range] = map2[a - 1][y + range];
            }

            // 위 가로
            for (int a = y + range; a > y - range; a--) {
                map2[x - range][a] = map2[x - range][a - 1];
            }

            map2[x - range][y - range + 1] = temp;
            range--;
        }
	}

	// 최소값 구하기 (각 행의 합 중 최소값)
	private static void calculate() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += map2[i][j];
			}
			if (min > sum) {
				min = sum;
			}
		}
	}

}

/*
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
 */
