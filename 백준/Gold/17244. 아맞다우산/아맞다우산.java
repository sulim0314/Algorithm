import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int x, y, dist, cnt;
		public Info(int x, int y, int dist, int cnt) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[][][] dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int Sx, Sy, Ex, Ey;
	static int key, result;
	static int INF = 2_000_000_000;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 7
		N = Integer.parseInt(st.nextToken()); // 6
		map = new int[N][M];
		dist = new int[N][M][1<<5]; // 최대 5개까지이므로 2^5
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<(1<<5); k++) {
					dist[i][j][k] = INF;
				}
			}
		}
		
		key = 0;
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				char c = line.charAt(j);
				if(c == 'X') {
					map[i][j] = key;
					key++;
				} else if(c == 'S') {
					Sx = i;
					Sy = j;
					map[i][j] = -1;
				} else if(c == 'E') {
					Ex = i;
					Ey = j;
					map[i][j] = -1;
				} else if(c == '.'){
					map[i][j] = -1;
				} else if(c == '#') {
					map[i][j] = 5; // 벽
				}
				
			}
		}
		
		go();
		System.out.println(dist[Ex][Ey][(1<<key) -1]);
//		System.out.println(key);
	}

	private static void go() {
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(Sx, Sy, 0, 0));
		dist[Sx][Sy][0] = 0;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			if(cur.x == Ex && cur.y == Ey && cur.cnt==((1<<key)-1)) {
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && map[nx][ny]!=5) {
					// 다음으로 갈 수 있을 때
					int nowKeyInfo = map[nx][ny];
					int nextKey = cur.cnt;
					if(0<=nowKeyInfo && nowKeyInfo<key) {
						// 하나라도 1이면 1로 bit check
						nextKey = nextKey | (1 << nowKeyInfo); 
					}
					if(dist[nx][ny][nextKey] > cur.dist+1) {
						dist[nx][ny][nextKey] = cur.dist+1;
						q.add(new Info(nx, ny, cur.dist+1, nextKey));
					}
				}
			}
			
		}
		
		
		
	}

}
