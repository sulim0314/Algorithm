package com.sulim.study_0817.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_D3_상호의배틀필드_고수림 {

	static int H, W, x, y, N, d;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
    static int[] dy = {0, 0, -1, 1};
    static char[] directions = {'^', 'v', '<', '>'};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken()); // 맵의 높이
			W = Integer.parseInt(st.nextToken()); // 맵의 너비

			map = new char[H][W];
			int tankX = -1;
			int tankY = -1;
			
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankX = i;
						tankY = j;
					} 
					if(map[i][j] == '^') {
						d = 0;
					} else if(map[i][j] == 'v') {
						d = 1;
					} else if(map[i][j] == '<') {
						d = 2;
					} else if(map[i][j] == '>') {
						d = 3;
					}
				}
			}

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 움직임 명령어 개수

			String commands = br.readLine(); // 움직임 명령어
			
			for (char command : commands.toCharArray()) {
				
				// 전차가 움직여야 하는 명령어일 때
				if (command == 'U' || command == 'D' || command == 'L' || command == 'R') {
					for (int i = 0; i < 4; i++) {
                        if (command == 'U' && directions[i] == '^') {
                            d = i; // 갈 방향 구하기
                            break;
                        } else if (command == 'D' && directions[i] == 'v') {
                            d = i; // 갈 방향 구하기
                            break;
                        } else if (command == 'L' && directions[i] == '<') {
                            d = i; // 갈 방향 구하기
                            break;
                        } else if (command == 'R' && directions[i] == '>') {
                            d = i; // 갈 방향 구하기
                            break;
                        }
                    }

					int nx = tankX + dx[d];
					int ny = tankY + dy[d];

					// 다음 위치가 . 일 때
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
						map[tankX][tankY] = '.'; // 원래 있던 자리 .으로 바꿔주기
						tankX = nx; 
						tankY = ny;
					}

					map[tankX][tankY] = directions[d]; // 탱크 방향 char 넣어주기
				
				} else if (command == 'S') {
					int shootX = tankX;
					int shootY = tankY;

					while (true) {
						shootX += dx[d];
                        shootY += dy[d];

						if (shootX < 0 || shootX >= H || shootY < 0 || shootY >= W) {
							break;
						}

						if (map[shootX][shootY] == '#') {
							break;
						}
						if (map[shootX][shootY] == '*') { 
							map[shootX][shootY] = '.';
							break;
						}
					}
				}
			}

			// 결과 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}


/*
1
3 7
***....
*-..#**
#<.****
23
SURSSSSUSLSRSSSURRDSRDS
*/

