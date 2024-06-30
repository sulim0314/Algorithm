import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<Integer> infected = new ArrayList<>();
    static List<Log> logs = new ArrayList<>();
    static boolean[] checked;

    static class Log implements Comparable<Log> {
        int t, src, dst;

        public Log(int t, int src, int dst) {
            this.t = t;
            this.src = src;
            this.dst = dst;
        }

        @Override
        public int compareTo(Log other) {
            return Integer.compare(this.t, other.t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            infected.add(Integer.parseInt(st.nextToken()));
        }

        if (infected.size() == 1) {
            System.out.println(infected.get(0));
            return;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            logs.add(new Log(t, src, dst));
        }

        Collections.sort(logs);

        checked = new boolean[N + 1];
        for (int infectedVertex : infected) {
            checked[infectedVertex] = true;
        }

        for (int infectedVertex : infected) {
            boolean[] visited = new boolean[N + 1];
            visited[infectedVertex] = true;
            int cnt = 1;

            for (Log log : logs) {
                if (visited[log.src] && !checked[log.dst]) {
                    break;
                }

                if (checked[log.src] && checked[log.dst] && visited[log.src] && !visited[log.dst]) {
                    visited[log.dst] = true;
                    cnt++;
                }
            }

            if (cnt == K) {
                System.out.println(infectedVertex);
                break;
            }
        }
    }
}
