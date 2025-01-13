import java.util.*;
import java.io.*;

public class Main {

    static class Info {
        int x, y;
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, L, R;
    static int answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Info> list; // 인구이동 필요

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();
        System.out.println(answer);

    }

    public static void move() {
        int result = 0;

        while(true) {
            boolean move = false;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j); // 열린 지역 총인구
                        if (list.size() > 1) {
                            changePopulation(sum); // 인구 변경
                            move = true;
                        }
                    }
                }
            }
            if(!move) {
                answer = result; // 이동이 없는 경우 정답 설정
                break; // 반복문 종료
            }
            result++;
        } // while

    }

    // 열린 지역 총인구 구하기
    public static int bfs(int x, int y) {
        Queue<Info> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new Info(x, y));
        list.add(new Info(x, y));
        visited[x][y] = true; // 시작점 방문 처리
        int sum = map[x][y];

        while(!q.isEmpty()) {
            Info cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                    if(L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        q.add(new Info(nx, ny));
                        list.add(new Info(nx, ny));
                        sum += map[nx][ny];
                    }
                }
            }
        }

        return sum;
    }

    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Info n : list) {
            map[n.x][n.y] = avg;
        }
    }
}
