import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] list;
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            list[b].add(a);
        }

        go(0);

        int result = 0;
        for(int i=0; i<N; i++) {
            if(visited[i]) {
                result++;
            }
        }

        System.out.println(result-1);

    }

    private static void go(int idx) {

        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i=0; i<list[cur].size(); i++) {
                int next = list[cur].get(i);
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }


    }
}




