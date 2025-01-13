import java.util.*;
import java.io.*;

public class Main {

    static class Info implements Comparable<Info> {
        int num, cnt;
        public Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int[] map;
    static boolean[] visited;
    static int N, M, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[101];
        visited = new boolean[101];
        for(int i=1; i<=100; i++) {
            map[i] = i;
        }

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from] = to;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from] = to;
        }

        go();
        System.out.println(result);

    }

    public static void go() {

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(1, 0));
        visited[1] = true;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(cur.num == 100) {
                result = cur.cnt;
                return;
            }

            for(int i=1; i<=6; i++) {
                int next = cur.num + i;
                if(next > 100) continue;
                if(!visited[next]) {
                    visited[next] = true;
                    pq.add(new Info(map[next], cur.cnt+1));
                }
            }

        }

    }
}
