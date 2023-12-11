import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int x, y;
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M; // 격자판
	static int H, W, Sr, Sc, Fr, Fc; // 직사각형 info
	static int[][] map;
	static int result;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static ArrayList<Info> list;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;
					list.add(new Info(i, j));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken())-1;
		Sc = Integer.parseInt(st.nextToken())-1;
		Fr = Integer.parseInt(st.nextToken())-1;
		Fc = Integer.parseInt(st.nextToken())-1;
		
		result = -1;
		go();
		System.out.println(result);
		
	}

	// Sr, Sc 부터 Fr, Fc 까지 이동
	private static void go() {

		Queue<Info> q = new LinkedList<>();
		q.add(new Info(Sr, Sc));
		visited[Sr][Sc] = true;
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			
			int curX = info.x;
			int curY = info.y;
			
			if(curX == Fr && curY == Fc) {
				result = map[curX][curY];
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && check(nx, ny)) {
					if(map[nx][ny] == 0) {
						q.add(new Info(nx, ny));
						visited[nx][ny] = true;
						map[nx][ny] = map[curX][curY] + 1;
					}
				}
			}
			
		}
		
	}

	// 시작부터 직사각형 모형이 다 벽이 아닌 곳에 위치한다면
	private static boolean check(int x, int y) {
		
		if(x+H-1 >= N || y+W-1 >= M) {
			return false;
		}

		for(int i=0; i<list.size(); i++) {
			Info info = list.get(i);
			if(x<= info.x && info.x<x+H && y<=info.y && info.y<y+W) {
				return false;
			}
		}
		
		return true;
		
	}

}
