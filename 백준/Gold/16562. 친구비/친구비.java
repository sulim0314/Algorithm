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
        if(aRoot == bRoot) return false; // cicle

        if(costs[aRoot] < costs[bRoot]) {
            parents[bRoot] = aRoot;
        } else {
            parents[aRoot] = bRoot;
        }
        return true;
    }

    static int[] parents, costs;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        int k = Integer.parseInt(st.nextToken()); // 돈

        parents = new int[N+1];
        for(int i=0; i<N+1; i++) {
            parents[i] = i;
        }
        costs = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            costs[i+1] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i=1; i<=N; i++) {
            hs.add(find(i));
        }

        for(int tmp: hs) {
            sum += costs[tmp];
        }

        if(sum <= k) {
            System.out.println(sum);
        } else {
            System.out.println("Oh no");
        }

    }
}
