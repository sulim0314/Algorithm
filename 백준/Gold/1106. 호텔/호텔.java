import java.util.*;
import java.io.*;

public class Main {

    static int C, N;
    static int[] dp; // i 명의 고객을 얻을 때 필요한 최소의 cost 저장.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C+101]; // 101
        Arrays.fill(dp,2_000_000_000);
        dp[0]=0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for(int j=people; j<C+101; j++){
                dp[j] = Math.min(dp[j], cost + dp[j-people]);
            }

        }

        int result=Integer.MAX_VALUE;
        for(int i=C; i<C+101; i++){
            result=Math.min(result,dp[i]);
        }
        System.out.println(result);

    }

}
