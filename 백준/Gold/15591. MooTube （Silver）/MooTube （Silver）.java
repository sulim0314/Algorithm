import java.io.*;
import java.util.*;

public class Main {

    static class Info {
        int to, w;
        public Info(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int N, Q;
    static ArrayList<Info>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        // 존은 값 K를 정해서, 그 동영상과 USADO가 K 이상인 모든 동영상이 추천되도록 할 것임.

        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            // 동영상 p와 q가 r (USADO) 로 서로 연결되어 있음.
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list[p].add(new Info(q, r));
            list[q].add(new Info(p, r));
        }

        for(int t=0; t<Q; t++) {
            // 만약 K=k라면, 동영상 v를 보고 있는 소들에게 몇 개의 동영상이 추천될 지 묻는 것.
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            System.out.println(solve(k, v));
        }

    }

    private static int solve(int k, int v) {

        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Info next : list[cur]) {
                if (!visited[next.to] && next.w >= k) {
                    visited[next.to] = true;
                    q.add(next.to);
                    cnt++;
                }
            }
        }

        return cnt;
    }


}
