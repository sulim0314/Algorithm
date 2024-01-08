import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {

	static class Monkey {
		int x, y;
		int cnt;
		int move;
		public Monkey(int x, int y, int cnt, int move) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.move = move;
		}
	}
	
	static int K,H,W;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] h_dx = {-1,-2,-2,-1,1,2,2,1};
	static int[] h_dy = {-2,-1,1,2,2,1,-1,-2};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); 
		H = Integer.parseInt(st.nextToken()); 
		
		map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		visited = new boolean[H][W][K+1];
		
		check();

	}

	private static void check() {
		
		Queue<Monkey> q = new LinkedList<>();
		q.add(new Monkey(0, 0, K, 0));
		visited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			if(cur.x == H-1 && cur.y == W-1) {
				System.out.println(cur.move);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(0<=nx && nx<H && 0<=ny && ny<W) {
					if(!visited[nx][ny][cur.cnt] && map[nx][ny] != 1) {
						visited[nx][ny][cur.cnt] = true;
						q.add(new Monkey(nx, ny, cur.cnt, cur.move+1));
					}
				}
			}

			if(cur.cnt > 0) {
				for(int i=0; i<8; i++) {
					int nx = cur.x + h_dx[i];
					int ny = cur.y + h_dy[i];
					
					if(0<=nx && nx<H && 0<=ny && ny<W) {
						if(!visited[nx][ny][cur.cnt-1] && map[nx][ny] != 1) {
							visited[nx][ny][cur.cnt-1] = true;
							q.add(new Monkey(nx, ny, cur.cnt-1, cur.move+1));
						}
					}
				}
			}
			
			if(q.isEmpty()) {
				System.out.println(-1);
			}
			
		}
		
	}

	
	
	
	
}
