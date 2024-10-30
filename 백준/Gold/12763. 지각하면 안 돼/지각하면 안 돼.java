import java.util.*;
import java.io.*;

public class Main {

    static class Info implements Comparable<Info> {
        int to, t, m;
        public Info(int to, int t, int m) {
            this.to = to;
            this.t = t;
            this.m = m;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.m, o.m);
        }
    }

    static class TM {
        int t, m;
        public TM(int t, int m) {
            this.t = t;
            this.m = m;
        }
    }

    static int N, time, money, L, result;
    static ArrayList<Info>[] list;
    static TM[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i=0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new TM[N+1];
        for(int i=0; i<N+1; i++) {
            dist[i] = new TM(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        for (int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list[a].add(new Info(b, t, m));
            list[b].add(new Info(a, t, m));
        }

        result = Integer.MAX_VALUE;
        go();

        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }


    private static void go() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(1, 0, 0));
        dist[1] = new TM(0, 0);

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            if(cur.m > money || cur.t > time) continue;

            if(cur.to == N) {
                result = Math.min(result, cur.m);
                continue; // ?
            }

            for(Info next : list[cur.to]) {
                int nextTime = cur.t + next.t;
                int nextMoney = cur.m + next.m;

                // 제한된 시간과 돈을 초과하면 해당 경로 무시
                if (nextTime > time || nextMoney > money) continue;

                // 최소 시간과 비용을 갱신할 경우에만 큐에 추가
                if (nextTime < dist[next.to].t || nextMoney < dist[next.to].m) {
                    dist[next.to] = new TM(nextTime, nextMoney);
                    pq.add(new Info(next.to, nextTime, nextMoney));
                }
            }

        } // while

    }

}
