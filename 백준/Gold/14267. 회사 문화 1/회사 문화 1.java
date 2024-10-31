import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] childList;
    static int[] good;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        good = new int[N + 1];
        childList = new ArrayList[N + 1];
        for(int i=0; i<N+1; i++) {
            childList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p != -1) {
                childList[p].add(i);
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            good[a] += b;
        }

        solve(1);

        for(int i=1; i<=N; i++) {
            sb.append(good[i]).append(" ");
        }

        System.out.println(sb);

    }

    private static void solve(int cur) {

        for(int i=0; i<childList[cur].size(); i++) {
            int next = childList[cur].get(i);
            good[next] += good[cur];
            solve(next);
        }

    }

}
