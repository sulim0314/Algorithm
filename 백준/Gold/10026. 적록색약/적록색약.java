import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] map1;
	static char[][] map2;
	static boolean[][] visited;
	static int cnt1, cnt2;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map1 = new char[N][N];
		map2 = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char temp = line.charAt(j);
				map1[i][j] = temp;
				if (temp == 'G') {
					map2[i][j] = 'R';
				} else {
					map2[i][j] = temp;
				}
			}
		}
		
		check1();
		visited = new boolean[N][N];
		check2();

		System.out.println(cnt1 + " " + cnt2);

	}

	private static void check1() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					solve1(i, j, map1[i][j]);
					cnt1++;
				}
			}
		}

	}

	private static void check2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					solve2(i, j, map2[i][j]);
					cnt2++;
				}
			}
		}
	}
	
	private static void solve1(int x, int y, char c) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map 범위 안에 있을 때
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(!visited[nx][ny] && map1[nx][ny] == c) {
					visited[nx][ny] = true;
					solve1(nx,ny,c);
				} 
			}
		}
	}

	private static void solve2(int x, int y, char c) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map 범위 안에 있을 때
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(!visited[nx][ny] && map2[nx][ny] == c) {
					visited[nx][ny] = true;
					solve2(nx,ny,c);
				} 
			}
		}
		
	}
}
