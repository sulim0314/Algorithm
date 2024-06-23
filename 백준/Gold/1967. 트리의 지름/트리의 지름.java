import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int idx, cnt;
        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    static int N;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, weight));
            list[b].add(new Node(a, weight));
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);

    }

    private static void dfs(int idx, int cnt) {
        for(int i=0; i<list[idx].size(); i++) {
            Node next = list[idx].get(i);
            if(!visited[next.idx]) {
                visited[next.idx] = true;
                dfs(next.idx, cnt + next.cnt);
            }
        }
        max = Math.max(max, cnt);
    }

}
