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
        if(aRoot == bRoot) return false; // 사이클 발생
        parents[bRoot] = aRoot;
        return true;
    }

    static int[] parents;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for(int i=0; i<=N; i++) {
            parents[i] = i;
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int startRoot = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if(startRoot != find(cur)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");


    }
}
