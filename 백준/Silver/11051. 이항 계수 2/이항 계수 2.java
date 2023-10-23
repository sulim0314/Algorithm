import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				if(j == 0) {
					dp[i][j] = 1;
				} else if(i == j) {
					dp[i][j] = 1;
				} else if(j == 1) {
					dp[i][j] = i;
				} else if(i>0 && j>0){
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
				}
			}
		}

		System.out.println(dp[N][K]);
		
	}

}
