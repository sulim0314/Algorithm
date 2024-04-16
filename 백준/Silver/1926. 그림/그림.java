import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M; // 세로, 가로
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static ArrayList<Integer> list;
	static boolean[][] visited;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count = 0;
					check(i, j);
					list.add(count);
				}
			}
		}
		
		if(list.size() == 0) {
            System.out.println(0);
			System.out.println(0);
			return;
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(list.get(list.size()-1));
		
		
	}
	
	public static void check(int a, int b) {
		visited[a][b] = true;
		count++;
		
		for(int i=0; i<4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					check(nx, ny); // dfs
				}
			}
		}
	}

}
