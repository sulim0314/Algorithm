import java.io.*;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int loc;
        long time;
        public Info(int loc, long time) {
            this.loc = loc;
            this.time = time;
        }
        @Override
        public int compareTo(Info o) {
            return Long.compare(this.time, o.time);
        }
    }

    static int N, M;
    static ArrayList<Info>[] list;
    static long[] minTime;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 지역의 수
        M = Integer.parseInt(st.nextToken()); // 횡단보도의 주기
        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }
        minTime = new long[N+1];
        Arrays.fill(minTime, Long.MAX_VALUE);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            // 1분동안 파란불이 들어오는 횡단보도의 두 끝점 a, b
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(new Info(b, i));
            list[b].add(new Info(a, i));
        }

        solve();
        System.out.println(minTime[N]);

    }

    private static void solve() {

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(1, 0));
        minTime[1] = 0;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int curLoc = cur.loc;
            long curTime = cur.time;

            if(minTime[curLoc] < curTime) continue;

            // 현재 있는 곳에서 갈 수 있는 루트들과 몇분에 갈 수 있는지 확인
            for(int i=0; i<list[curLoc].size(); i++) {
                Info next = list[curLoc].get(i);
                int nextLoc = next.loc; // 어디로
                long nextTime; // 몇분에

                if (curTime <= next.time) {
                    nextTime = next.time + 1;
                } else {
                    nextTime = ((long) Math.ceil(((double)cur.time - next.time)/M)) * M + next.time + 1;
                }

                if (nextTime < minTime[nextLoc]) {
                    minTime[nextLoc] = nextTime;
                    pq.add(new Info(nextLoc, nextTime));
                }

            }


        }


    }

}
