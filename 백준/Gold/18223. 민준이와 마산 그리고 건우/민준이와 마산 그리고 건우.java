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

    static int N, M, P;
    static ArrayList<Info>[] list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Info(b, c));
            list[b].add(new Info(a, c));
        }

        int aToB = go(1, P);
        int bToC = go(P, N);
        int aToC = go(1, N);

        if(aToB + bToC == aToC) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }


    }


    private static int go(int start, int end) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
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
