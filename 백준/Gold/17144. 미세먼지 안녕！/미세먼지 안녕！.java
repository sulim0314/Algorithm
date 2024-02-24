import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int x, y, p;

		public Info(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}

	static int R, C, T;
	static int[][] map;
	static int[] air;
	static Queue<Info> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C]; // 초기화 되어있음.
		air = new int[4]; // 상_x : air[0], 상_y : air[1]
							// 하_x : air[2], 하_y : air[3]
		q = new LinkedList<>();
		int result = 0;
		
		int idx = 0; // air에 넣기 위한
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > 0) {
					q.add(new Info(i, j, tmp));
				} else if (tmp == -1) {
					air[idx] = i;
					air[idx+1] = j;
					idx += 2;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			// 맵에 아무것도 없음
			spread(); // 뿌리기
			doAir(); // 공기청정기
			
			if(i < T-1) { // 마지막은 빼고 (result에 더해야하니까)
				pick(); // q에 다시 넣기
				map = new int[R][C]; // 맵초기화
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}

		System.out.println(result);
	}

	private static void pick() {
		// 주워담기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					q.add(new Info(i, j, map[i][j]));
				}
			}
		}
		
	}

	private static void spread() {

		while (!q.isEmpty()) {
			Info cur = q.poll();
			int plus = cur.p / 5;
			
			for (int i = 0; i < 4; i++) { // 주변애들한테 plus 해주기
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if((nx == air[0] && ny ==0) || (nx == air[2] && ny ==0)) continue;
					map[nx][ny] += plus;
					cur.p -= plus;
				}
			}

			// 다 나눠주고 내꺼 챙기기
			map[cur.x][cur.y] += cur.p;
		} // 1초동안 나눠줬음
		
	}

	private static void doAir() {
		
		// 이제 1초동안 공기청정기 작동하기 // 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.
		// 상 : map[air[0]][air[1]사실 0];
		// 하 : map[air[2]][air[3]사실 0];

		// 상 : 상 -> 하
		for (int i = 2; i <= air[0]; i++) {
			map[air[0] - i + 1][0] = map[air[0] - i][0];
			map[air[0] - i][0] = 0;
		}
		// 상 : 우 -> 좌
		for (int i = 1; i < C; i++) {
			map[0][i - 1] = map[0][i];
			map[0][i] = 0;
		}
		// 상 : 하 -> 상
		for (int i = 1; i <= air[0]; i++) {
			map[i - 1][C - 1] = map[i][C - 1];
			map[i][C - 1] = 0;
		}
		// 상 : 좌 -> 우
		for (int i = 1; i < C; i++) {
			map[air[0]][C - i] = map[air[0]][C - i - 1];
			map[air[0]][C - i - 1] = 0;
		}

		// 하 : 하 -> 상
		for (int i = 2; i < R - air[2]; i++) {
			map[air[2]+i-1][0] = map[air[2]+i][0];
			map[air[2]+i][0] = 0;
		}
		// 하 : 우 -> 좌
		for (int i = 1; i < C; i++) {
			map[R - 1][i - 1] = map[R - 1][i];
			map[R - 1][i] = 0;
		}
		// 하 : 상 -> 하
		for (int i = 1; i < R - air[2]; i++) {
			map[R - i][C - 1] = map[R - i - 1][C - 1];
			map[R - i - 1][C - 1] = 0;
		}
		// 하 : 좌 -> 우
		for (int i = 1; i < C; i++) {
			map[air[2]][C - i] = map[air[2]][C - i - 1];
			map[air[2]][C - i - 1] = 0;
		}

	}

}
