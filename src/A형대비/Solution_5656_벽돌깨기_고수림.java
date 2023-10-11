package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_고수림 {

	static class Info {
		int x, y, p;
		public Info(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}
	
	static int min;
	static int[][] map, map_origin;
	static int N, W, H;
	static int[] data, num;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Info> q;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 공 개수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map_origin = new int[H][W];
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map_origin[i][j] = temp;
					map[i][j] = temp;
				}
			}
			
			data = new int[W];
			for(int i=0; i<W; i++) {
				data[i] = i;
			}
			num = new int[N];
			per(0);
			
			System.out.println("#"+tc+" "+min);
		}
		
	}
	private static void go(int n) {

		q = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			if(map[i][n] > 0) {
				q.add(new Info(i, n, map[i][n]));
				map[i][n] = 0;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			// 4방향 깨면서 큐에 넣어
			for(int i=0; i<4; i++) { // 범위 체크해주기 !! // power만큼 넣어야함
				for(int j=1; j<cur.p; j++) {
					int nx = cur.x + dx[i]*j;
					int ny = cur.y + dy[i]*j;
					if(0<=nx && nx<H && 0<=ny && ny<W && map[nx][ny] > 0) {
						int nPower = map[nx][ny];
			            map[nx][ny] = 0;
			            if(nPower > 1) {
			                q.add(new Info(nx, ny, nPower));
			            }
					}
				}
			}
		}
		
	}

	private static void dropBricks() {
		
		for(int j=0; j<W; j++) {
			for(int i=H-1; i>=0; i--) {
				if(map[i][j] == 0) { // 빈 공간 찾음
					int higher = i-1; // 현재보다 한 칸 위
					while(higher >= 0 && map[higher][j] == 0) {
						higher--;
					}
					if(higher >= 0) {
						map[i][j] = map[higher][j]; // 교환
						map[higher][j] = 0;
					}
				}
			}
		}
		
	}
	// 중복순열, W개 중에서 N개 뽑기
	private static void per(int cnt) {
		if(cnt == N) {
			int val = 0;
			// map 초기화
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = map_origin[i][j];
				}
			}
			// num 순서대로 시뮬 시작
			for(int i=0; i<N; i++) {
				go(num[i]);
				dropBricks();
			} // N번 다 깨줬음
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] > 0) {
						val ++;
					}
				}
			}
			
			min = Math.min(min, val);
			
			return;
		}
		
		for(int i=0; i<W; i++) {
			num[cnt] = i;
			per(cnt+1);
		}
		
	}

}
