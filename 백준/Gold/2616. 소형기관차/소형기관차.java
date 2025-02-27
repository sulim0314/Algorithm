import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] people, prifixSum;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        people = new int[N+1];
        prifixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            prifixSum[i] = prifixSum[i-1] + people[i];
        }

        M = Integer.parseInt(br.readLine());
        dp = new int[4][N+1];

        // 0 35 40 50  10  30  45  60
        // 0 35 75 125 135 165 210 270
        for (int i = 1; i <= 3; i++) {
            for (int j = i*M; j <= N; j++) {
                dp[i][j] = Math.max(
                    dp[i][j-1],
                    dp[i-1][j-M] + prifixSum[j] - prifixSum[j-M]
                );
            }
        }

        System.out.println(dp[3][N]);

    }

}
