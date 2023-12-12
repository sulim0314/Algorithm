import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x= x;
			this.y = y;
		}
	}
	
	static int H, W;
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	
	// 좌, 좌상 | 우상, 우, 우하 | 좌하 (시계방향)
	static int[][] odd = {{-1,0},{0,-1},{1,0},{1,1},{0,1},{-1,1}};
    static int[][] even = {{-1,-1},{0,-1},{1,-1},{1,0},{0,1},{-1,0}};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken()); // 8 (가로) 
		H = Integer.parseInt(st.nextToken()); // 4 (세로)
		
		map = new int[H+2][W+2]; // 외벽과 닿는 모든 면을 정육각형으로 둘러주기 위해 +2
		visited = new boolean[H+2][W+2];
		result = new int[H+2][W+2];
		for(int i=1; i<=H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		
		solve(0,0); // bfs
		
		int answer = 0;
		for(int i=0; i<H+2; i++) {
			for(int j=0; j<W+2; j++) {
				answer += result[i][j];
			}
		}
		
		System.out.println(answer);
		
	}

	private static void solve(int startX, int startY) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(startX, startY));		
		visited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			
			for(int i=0; i<6; i++) {
				int nx, ny;
				
				if(x % 2 == 0) {
					nx = x + even[i][0];
					ny = y + even[i][1];
				} else {
					nx = x + odd[i][0];
					ny = y + odd[i][1];
				}
				
				if(0<=nx && nx<H+2 && 0<=ny && ny<W+2) {
					if(map[nx][ny] == 1) {
						result[x][y]++;
						//
					}
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
					}
				}
				
			}
			
		}
		
		
	}

}
