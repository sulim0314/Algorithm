import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map, dp;
	static int N, result, lastBit, INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		lastBit = (1<<N) - 1;
		
		dp = new int[N][lastBit]; // ??
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(check(0,1)); // 0번 도시부터 탐색 시작
		
	}

	private static int check(int x, int flag) {

		// 모든 도시 방문 완료
		if(flag == lastBit) {
			if(map[x][0] == 0) {
				return INF; // ??
			} else {
				return map[x][0];
			}
		}

		// 이미 방문했다면,
		if(dp[x][flag] != -1) {
			return dp[x][flag];
		}
		dp[x][flag] = INF;
		
		for(int i=0; i<N; i++) {
			// next로 i번째 도시 방문
			int next = flag | (1<<i);
			
			// 경로 없거나, 이미 방문했을 경우, continue
			if(map[x][i] == 0 || (flag & (1<<i)) != 0) {
				continue;
			}
			
			dp[x][flag] = Math.min(dp[x][flag], check(i, next) + map[x][i]);
			
		}
		
		return dp[x][flag];
	}

}
