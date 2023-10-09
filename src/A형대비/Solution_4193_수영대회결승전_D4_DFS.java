package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author sulim
 * 
 *	목적지 도달못할 때 -1로 바꿔주기
 *	처음 result = Integer.MAX_VALUE; 로 설정하여, min값으로 갱신해주고, min보다 커지면 계산하지 않도록 !
 *	
 *	int waitTime = (3 - ((time+1) % 3)) % 3; // 소용돌이 대기 시간 계산
 *	visited[nx][ny] = true;
 *	go(nx, ny, time + 1 + waitTime);
 *	visited[nx][ny] = false;
 *
 */

public class Solution_4193_수영대회결승전_D4_DFS {

	static int N, result;
	static int[][] map;
	static boolean[][] visited;
	static int s_x, s_y, e_x, e_y;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = Integer.MAX_VALUE;
			s_x=-1; s_y=-1; e_x=-1; e_y=-1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			s_x = Integer.parseInt(st.nextToken());
			s_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			e_x = Integer.parseInt(st.nextToken());
			e_y = Integer.parseInt(st.nextToken());
			
			visited[s_x][s_y] = true;
			go(s_x, s_y, 0);
			
			if(result == Integer.MAX_VALUE) result = -1;
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void go(int cur_x, int cur_y, int time) {
		
		if(time >= result || time > N*N) return;
		
		if(cur_x == e_x && cur_y == e_y) {
			result = Math.min(result, time);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = cur_x + dx[i];
			int ny = cur_y + dy[i];
			// 갈 수 있을 때
			if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny]!=1) {
				// 갔던 길 아닐 때 체크
				if(!visited[nx][ny]) {
					// 소용돌이일 때
					if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny]!=1 && !visited[nx][ny]) {
			            if(map[nx][ny] == 2) {
			                int waitTime = (3 - ((time+1) % 3)) % 3; // 소용돌이 대기 시간 계산
			                visited[nx][ny] = true;
			                go(nx, ny, time + 1 + waitTime);
			                visited[nx][ny] = false;
			            } else {
			                visited[nx][ny] = true;
			                go(nx, ny, time+1);
			                visited[nx][ny] = false;
			            }
			        }
				}
			}
		}
		
	}
}
