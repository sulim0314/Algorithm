import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
        map = new int[N][M];
        dp = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
                dp[i][j] = -1;
            }
        }

        dp[N-1][M-1] = 1;
        System.out.println(go(0, 0));

    }
    
    private static int go(int x, int y) {
        
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = 0;
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            if(map[x][y] > map[nx][ny]) {
  		        dp[x][y] += go(nx,ny);
            }
        }
        
        return dp[x][y];
        
    }
}
