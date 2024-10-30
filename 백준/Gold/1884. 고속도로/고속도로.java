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
            return Integer.compare(this.t, o.t);
        }
    }

    static int N, M, money, result;
    static ArrayList<Info>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        money = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i=0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()); // 길이
            int m = Integer.parseInt(st.nextToken()); // 통행료

            list[a].add(new Info(b, t, m));
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

        // dist[node][cost]: 특정 노드까지 해당 비용으로 도달할 때의 최소 시간
        int[][] dist = new int[N + 1][money + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][0] = 0;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            // 만약 현재 노드까지의 시간이 이미 저장된 최소 시간보다 크면 탐색 중단
            if (cur.t > dist[cur.to][cur.m]) continue;

            if(cur.to == N) {
                result = Math.min(result, cur.t);
            }

            for(Info next : list[cur.to]) {
                int nextTime = cur.t + next.t;
                int nextMoney = cur.m + next.m;

                // 제한된 시간과 돈을 초과하면 해당 경로 무시
                if (nextMoney > money) continue;

                // 특정 비용 내에서 더 적은 시간으로 도달할 수 있는 경우에만 갱신 및 큐에 추가
                if (nextTime < dist[next.to][nextMoney]) {
                    dist[next.to][nextMoney] = nextTime;
                    pq.add(new Info(next.to, nextTime, nextMoney));
                }
            }

        } // while

    }

}
