import java.util.*;
import java.io.*;

public class Main {

    static class Info implements Comparable<Info> {
        int x, y, m, f;

        public Info(int x, int y, int m, int f) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.f = f;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.m, o.m);
        }
    }

    static int W, H;
    static int[][] map;
    static int[][][] dist;
    static int Sx, Sy, Fx, Fy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        dist = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], 2_000_000_000);
            }
        }

        boolean sOrF = false;
        for(int i=0; i<H; i++) {
            String line = br.readLine();
            for(int j=0; j<W; j++) {
                char c = line.charAt(j);
                if(c == '.') {
                    map[i][j] = 0;
                } else if(c == '*') {
                    map[i][j] = -1;
                } else { // c == C
                    map[i][j] = 0;
                    if(!sOrF) {
                        sOrF = true;
                        Sx = i;
                        Sy = j;
                    } else {
                        Fx = i;
                        Fy = j;
                    }
                }
            }
        } // map 입력 끝

        System.out.println(solve());

    }

    private static int solve() {
        PriorityQueue<Info> pq = new PriorityQueue<>();

        for (int i = 0; i < 4; i++) {
            int nx = Sx + dx[i];
            int ny = Sy + dy[i];
            if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0) {
                pq.add(new Info(nx, ny, 0, i));
                dist[Sx][Sy][i] = 0;
            }
        }

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            if(cur.x == Fx && cur.y == Fy) {
                return cur.m;
            }

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == -1) continue;

                int num = (cur.f == i) ? 0 : 1;
                if (dist[nx][ny][i] > cur.m + num) {
                    dist[nx][ny][i] = cur.m + num;
                    pq.add(new Info(nx, ny, cur.m + num, i));
                }
            }
        } // while

        return -1;
    }

}
