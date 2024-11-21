import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dp;
    static boolean[][] visited;
    static int N, M, max;
    static boolean flag = false;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                int tmp = line.charAt(j);
                if(tmp != 'H') {
                    int num = tmp - '0';
                    map[i][j] = num;
                } else {
                    map[i][j] = -1;
                }
            }
        }
        
        visited[0][0] = true;
        
		go(0, 0, 1);

		if(flag) {
			System.out.println("-1");
		}
		else {
			System.out.println(max);
		}
        
    }
    
    
    private static void go(int x, int y, int cnt) {
        if(cnt>max) {
			max = cnt;
		}
		dp[x][y] = cnt;

        for(int i=0; i<4; i++) {
            int move = map[x][y];
            int nx = x + (move * dx[i]);
            int ny = y + (move * dy[i]);
            
            if(nx<0 || ny<0 || nx>N-1 || ny>M-1 || map[nx][ny] == -1) {
				continue;
			}

			if(visited[nx][ny]) {
				flag = true;
				return;
			}

            // 이미 깊이 탐색한 부분 스킵
			if(dp[nx][ny] > cnt) continue;
			
			visited[nx][ny]= true;
			go(nx, ny, cnt+1);	
			visited[nx][ny]= false;
            
            
        }
        
    }
    
}
