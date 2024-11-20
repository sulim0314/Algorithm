import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dp;
    static int N, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];

        // 어떤 지점에 처음 풀어놓아야 할 지
        // 어떻게 이동시켜야 최대한 많은 칸!을 방문할 수 있는지.

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                max = Math.max(max, go(i, j));
            }
        }

        System.out.println(max);

    }

    private static int go(int x, int y) {

        // dp에 저장된 값 있으면, 그 값 반환.
        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if(map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], go(nx, ny) + 1);
                go(nx, ny);
            }
        }


        return dp[x][y];

    }

}
