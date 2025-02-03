import java.util.*;
import java.io.*;

public class Main {

    static class Info implements Comparable<Info> {
        int to, c;
        public Info(int to, int c) {
            this.to = to;
            this.c = c;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.c, o.c);
        }
    }

    static int N, M; // 헛간, 길
    static ArrayList<Info>[] list;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dist = new int[N + 1];
        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Info(B, C));
            list[B].add(new Info(A, C));
        }

        go();
        System.out.println(dist[N]);

    }

    private static void go() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.c;

            if (dist[now] < nowCost) continue;

            for (Info next : list[now]) {
                int newCost = nowCost + next.c;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Info(next.to, newCost));
                }
            }
        }

    }

}
