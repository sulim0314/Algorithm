import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static long[][][] dp;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		dp = new long[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1; 				///////////////////
				}
			}
		}

		dp[0][1][0] = 1;

		long result = solve(N-1, N-1, 0) + solve(N-1, N-1, 1) + solve(N-1, N-1, 2);

		System.out.println(result);

	}

	private static long solve(int x, int y, int dir) {

		if (x < 0 || N <= x || y < 0 || N <= y) {
			return 0;
		}
		if (map[x][y] == 1) {
			return dp[x][y][dir] = 0;
		}
		if (dp[x][y][dir] != -1) { /////////////
			return dp[x][y][dir];
		}

		dp[x][y][dir] = 0;
		
		if (dir == 0) {
			dp[x][y][dir] = solve(x, y-1, 0) + solve(x, y-1, 1);
		} else if (dir == 1) {
			if(0<=x-1 && 0<=y-1 && map[x-1][y] != 1 && map[x][y-1] != 1) {
				dp[x][y][dir] = solve(x-1, y-1, 0) + solve(x-1, y-1, 1) + solve(x-1, y-1, 2);
			}
		} else if (dir == 2) {
			dp[x][y][dir] = solve(x-1, y, 1) + solve(x-1, y, 2);
		}

		return dp[x][y][dir];
	}

}
