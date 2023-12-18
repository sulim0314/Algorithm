import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// K개 더해서 N만들기
	static int N, K;
	static int[][] dp;
	static final int mod = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[201][201]; // dp[K][N]

		for(int i=0; i<201; i++) {
			dp[1][i] = 1;
			dp[i][0] = 1;
		}
		dp[0][0] = 0;
		
		for(int i=2; i<201; i++) {
			for(int j=1; j<201; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= mod;
			}
		}
		
		System.out.println(dp[K][N]);
		
	}

}
