import java.util.*;
import java.io.*;

public class Main {

    static class Info implements Comparable<Info> {
        int to, w;
        public Info(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int N, M;
    static ArrayList<Info>[] list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
           list[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Info(b, c));
            list[b].add(new Info(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(go(start, end));

    }

    private static int go(int start, int end) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));
        dist[start] = 0;
        boolean[] check = new boolean[N+1];

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            if(cur.to == end) {
                return cur.w;
            }

            if(check[cur.to]) continue;
            check[cur.to] = true;

            for(int i=0; i<list[cur.to].size(); i++) {
                Info next = list[cur.to].get(i);

                if(dist[next.to] > cur.w + next.w) {
                    dist[next.to] = cur.w + next.w;
                    pq.add(new Info(next.to, dist[next.to]));
                }
            }

        }

        return -1;

    }

}
