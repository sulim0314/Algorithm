import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int[] novel;
	static int[] sum;
	static int K;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());	
			dp = new int[K+1][K+1];
			novel = new int[K+1];
			sum = new int[K+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				novel[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + novel[i]; // i번째까지 누적합
			}
			solve();
		}
	}

	private static void solve() {

		// i부터 j까지 dp구할껀데, n은 i와 j의 차이
		for(int n=1; n<=K; n++) { 
			for(int i=1; i+n<=K; i++) {
				int j = i+n;
				dp[i][j] = Integer.MAX_VALUE;
				for(int x=i; x<j; x++) {
					dp[i][j] = Math.min(dp[i][j], 
							dp[i][x] + dp[x+1][j] + sum[j] - sum[i-1]);
				}
			}
		}
		System.out.println(dp[1][K]);
	}

}
