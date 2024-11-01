import java.util.*;
import java.io.*;

public class Main {

    static int N; // N <= 30
    static int[] w;
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        w = new int[N];
        dp = new boolean[N+1][40001]; // i: 추 몇개, j: 무게

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            w[i] = num;
        }

        solve(0, 0);

        int c = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++) {
            int check = Integer.parseInt(st.nextToken());
            boolean flag = false;

            for(int j=0; j<N+1; j++) {
                if(dp[j][check]) {
                    sb.append("Y ");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("N ");
            }
        }

        System.out.println(sb);

    }

    private static void solve(int cnt, int num) {

        if(dp[cnt][num]) return;
        dp[cnt][num] = true;

        if(cnt == N) return; // 마지막

        solve(cnt+1, num + w[cnt]);
        solve(cnt+1, num);
        solve(cnt+1, Math.abs(num - w[cnt]));

    }
}
