import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] dp;
    static int[] W, V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 물건 수
        K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
        W = new int[N+1];
        V = new int[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // dp[x][y] : 최대 무게 y인 가방에서, x번째 물건까지의 최대 가치
        dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++) { // i번째 물건까지 고려함.
            for(int j=1; j<=K; j++) { // 현재 담을 수 있는 최대 무게 j.

                if(W[i] > j) { // 더 담을 수 없음
                    dp[i][j] = dp[i-1][j];
                }

                else { // 더 담을 수 있음
                                // 안담은거, 담은거 의 max
                                                  // i-1 번째 물건까지 고려했을 때,
                                                  // j-W[i]의 가방에 담을 수 있는 가치에 더하기
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }

            }
        }

        System.out.println(dp[N][K]);

    }

}
