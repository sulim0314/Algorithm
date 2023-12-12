import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, max;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Map<Integer, Integer> hm = new HashMap<>(); // 각 덩어리의 id와 size
	static Queue<Point> q = new LinkedList<>(); // for Zero

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					q.add(new Point(i, j));
				}
			}
		}
		
		/* DFS를 통한 각 덩어리(모양)의 인덱스를 부여하고, 그 크기를 구한다. */
		int id = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					int size = dfs(i, j, id);
					hm.put(id++,  size);
				}
			}
		}
		
		/* Queue에 넣은 0을 하나씩 꺼내 1로 변경했을 때 인접한 덩어리들과 크기를 합쳐본다. */
		Set <Integer> set = new HashSet<>();
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int val = 1;
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && map[nx][ny]!=0) {
					if(set.add(map[nx][ny])) {
						val += hm.get(map[nx][ny]);
					}
				}
			}
			
			max = Math.max(max, val);
			set.clear();
		}

		System.out.println(max);
		
	}

	private static int dfs(int x, int y, int id) {

		visit[x][y] = true;
		map[x][y] = id;
		int result = 1;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M && !visit[nx][ny] && map[nx][ny]!=0) {
				result += dfs(nx, ny, id);
			}
		}
		
		return result;
	}

}
