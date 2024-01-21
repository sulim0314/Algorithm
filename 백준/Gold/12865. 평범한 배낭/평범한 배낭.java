import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] item = new int[N + 1][2]; // weight, value

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			item[i][0] = w;
			item[i][1] = v;
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j - item[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], item[i][1] + dp[i - 1][j - item[i][0]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
