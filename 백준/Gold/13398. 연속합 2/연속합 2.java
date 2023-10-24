import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][2];
		dp[0][0] = data[0];
		dp[0][1] = data[0];
		
		int max = data[0];
		// 제거 한번도 안한건 0 에 넣는다.
		// 제거 하는 경우 1 에 넣는다.
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.max(dp[i-1][0]+data[i], data[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+data[i]); // 왼쪽이 제거하는 경우, 오른쪽은 그대로
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(max);
	}

}
