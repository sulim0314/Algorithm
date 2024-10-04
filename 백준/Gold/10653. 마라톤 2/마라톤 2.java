import java.util.*;
import java.io.*;


public class Main {

    static int N, K;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[i][0] = x;
            board[i][1] = y;
        }

        int[][] dp = new int[N][K+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<=K; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 맨 처음, 0개 건너뛴 최소값.
        dp[0][0] = 0;

        for(int i=1; i<N; i++) {
            dp[i][0] = dp[i-1][0] + cal(board[i], board[i-1]);

            for(int j=1; j<=K; j++) {
                int idx = j;

                for(int k=i-1; k>=0; k--) {
                    if(dp[k][idx] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][idx] + cal(board[i], board[k]));
                    }

                    idx--;

                    if(idx < 0) break;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0;i<=K;i++){
            result = Math.min(result , dp[N-1][i]);
        }
        System.out.println(result);

    }

    static int cal(int[] x1,int[] x2) {
        return Math.abs(x1[0] - x2[0]) + Math.abs(x1[1] - x2[1]);
    }

}
