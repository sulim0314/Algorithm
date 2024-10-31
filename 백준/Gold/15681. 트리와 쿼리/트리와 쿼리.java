import java.util.*;
import java.io.*;

public class Main {

    static int[] numOfChild;
    static List<Integer>[] list;
    static int n, root, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }
        numOfChild = new int[n+1];
        Arrays.fill(numOfChild, 1); // 일단 본인

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        go(root,-1);

        for(int i=0; i<q; i++) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(numOfChild[idx]).append("\n");
        }

        System.out.println(sb);

    }

    // DFS를 이용해 각 노드의 서브트리 크기를 계산
    static void go(int idx, int parent) {

        for(int next : list[idx]) {
            if(parent != next) {
                go(next, idx);
            }
        }

        // 루트가 아닐 때, parent의 child를 더해줘야함.
        if(parent != -1) {
            numOfChild[parent] += numOfChild[idx];
        }
    }

}
