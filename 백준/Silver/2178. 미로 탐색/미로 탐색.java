import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Info {
		int x,y,cnt;
		public Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int N, M; 
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		
	}
	
	private static void bfs(int x, int y) {
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(x, y, 1));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			if(cur.x == N-1 && cur.y == M-1) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny] && (map[nx][ny] == 1)) {
						q.add(new Info(nx, ny, cur.cnt+1));
						visited[nx][ny] = true;
					}
				}
			}
			
		}
		
	}
		
	

}
