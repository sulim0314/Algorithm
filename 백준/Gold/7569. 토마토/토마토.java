import java.util.*;
import java.io.*;

public class Main {
    
    static class Info {
        int x, y, z, cnt;
        public Info(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        } 
    }
    
    static int N, M, H;
    static int[][][] map;
    
    // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static Queue<Info> q;
    static int tomato;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        q = new LinkedList<>();
        
        tomato = 0;
        for(int k=0; k<H; k++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j][k] = num;
                    if(num != -1) {
                        tomato++;
                    }
                    if(num == 1) {
                        q.add(new Info(i, j, k, 0));
                    }
                }
            }
        }
        
        go();
        
    }
    
    private static void go() {
        int totalTomato = q.size();
        int cntMax = 0;
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            cntMax = Math.max(cntMax, cur.cnt);
            
            for(int d=0; d<6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];
                
                if(nx<0 ||nx>=N || ny<0 || ny>=M || nz<0 || nz>=H) continue;
                
                if(map[nx][ny][nz] == 0) {
                    map[nx][ny][nz] = 1;
                    totalTomato++;
                    q.add(new Info(nx, ny, nz, cur.cnt+1));
                }
            }
            
            
        }
        
        if(totalTomato == tomato) {
            System.out.println(cntMax);
        } else {
            System.out.println(-1);
        }
        
    }
    
    
}
