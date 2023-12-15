import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] dp = new long[55]; // 10^16까지 2^54임
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// dp[n] = dp[n-1]*2 + 2^n 
		dp[0] = 1;
		for(int i=1; i<55; i++) {
			dp[i] = (dp[i-1]<<1) + (1L<<i); // 괄호 꼭 해주기
		}
		
		long result = count1(B) - count1(A-1);
		System.out.println(result);
	}

	// 1~n 정수에 대한 1의 개수 구하기
	private static long count1(long n) {

		long count = n & 1;
		int size = (int) (Math.log(n)/Math.log(2)); // n보다 작은 2의 최대 거듭제곱수 만약 n이 13이면, size=3
		
		for(int i=size; i>0; i--) {
			if((n & (1L<<i)) != 0L) { // n의 i번째 비트가 1이라면
				count += dp[i-1] + (n - (1L<<i) + 1);
				n -= 1L<<i;	// 현재 검사한 비트를 제거
			}
		}
		
		return count;
	}

}
