import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Info implements Comparable<Info> {
        int x, y, w;

        public Info(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static final int INF = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = 0;
        while(true) {
            t++;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0; i< N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j< N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            sb.append("Problem ").append(t).append(": ").append(solve()).append("\n");
        }

        System.out.println(sb);

    }

    private static int solve() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, map[0][0]));
        visited[0][0] = true;
        dist[0][0] = map[0][0];

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            visited[cur.x][cur.y] = true;

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || N <= nx || ny < 0 || N <= ny || visited[nx][ny]) continue;

                if(dist[nx][ny] > cur.w + map[nx][ny]) {
                    dist[nx][ny] = cur.w + map[nx][ny];
                    pq.add(new Info(nx, ny, cur.w + map[nx][ny]));
                }


            }


        }

        return dist[N-1][N-1];
    }

}
