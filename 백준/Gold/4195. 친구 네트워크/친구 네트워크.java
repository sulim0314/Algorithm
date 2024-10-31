import java.util.*;
import java.io.*;

public class Main {

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static int union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) {
            if(aRoot > bRoot) { // b가 부모
                parents[aRoot] = bRoot;
                level[bRoot] += level[aRoot];
                return level[bRoot];
            } else { // a가 부모
                parents[bRoot] = aRoot;
                level[aRoot] += level[bRoot];
            }
        }
        return level[aRoot];
    }

    static int T, F;
    static int[] parents, level;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 각 친구 관계마다 두 사람이 속한 네트워크의 크기 구하기 !!
        T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++) {
            F = Integer.parseInt(br.readLine());

            parents = new int[2 * F]; // 총 인물이 최대 2*F 명
            level = new int[2 * F];
            for(int i=0; i<2*F; i++) {
                parents[i] = i;
                level[i] = 1;
            }

            Map<String, Integer> hm = new HashMap<>();
            int idx = 0;

            for(int i=0; i<F; i++) {
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();

                if(!hm.containsKey(first)) {
                    hm.put(first, idx++);
                }
                if(!hm.containsKey(second)) {
                    hm.put(second, idx++);
                }

                sb.append(union(hm.get(first), hm.get(second)) + "\n");
            }

        }

        System.out.println(sb);
    }
}
