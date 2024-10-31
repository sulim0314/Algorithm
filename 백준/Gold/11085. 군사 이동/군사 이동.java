import java.util.*;
import java.io.*;

public class Main {

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Info implements Comparable<Info> {
        int from, to, w;
        public Info(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(o.w, this.w); // 가중치가 큰 간선부터 !
        }
    }

    static int N, M;
    static int start, end;
    static int[] parents;
    static PriorityQueue<Info> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }

        pq = new PriorityQueue<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Info(from, to, w));
        }

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            if(!union(cur.from, cur.to)) continue;

            if(find(start) == find(end)) {
                System.out.println(cur.w);
                break;
            }

        }

    }


}
