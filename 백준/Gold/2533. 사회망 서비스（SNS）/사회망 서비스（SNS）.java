import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    // 자신이 얼리어답터일때와 얼리어답터가 아닐 때, 2가지로 나누어 최솟값 저장 dp
    static int[][] dp; // dp[x][y]: 노드 x가 얼리 어답터(y=1)일 때와 아닐 때(y=0) 최솟값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /*
            부모 노드가 얼리어답터가 아니면 자식 노드들은 모두 !! 얼리어답터여야 함.
            But, 부모 노드가 얼리어답터이면 자식 노드들은 반드시 얼리어답터 아니어도 됨. 
        */

        n = Integer.valueOf(br.readLine());
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        go(1);

        // 루트 노드가 얼리어답터일 때와 아닐 때의 최솟값
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void go(int num) {

        visited[num] = true;
        dp[num][0] = 0; // 해당 num이 얼리어답터가 아닌 경우
        dp[num][1] = 1; // 해당 num이 얼리어답터인 경우 (우선 본인이 맞으니까 1)

        // 현재 노드의 자식 노드들을 탐색
        for(int child : list[num]) {
            if(!visited[child]) {
                go(child); // 자식 노드로 재귀 호출하여 DP 계산 먼저 !
                dp[num][0] += dp[child][1];
                dp[num][1] += Math.min(dp[child][0] , dp[child][1]); // 상관없으니까 둘 중에 작은 것
            }
        }

    }

}
