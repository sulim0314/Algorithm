import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] list;
    static int[] dp; // 각 직원이 모든 부하 직원에게 뉴스를 전하는 데 걸리는 최소 시간
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList[N];
        dp = new int[N];

        int root = 0;
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
            } else {
                list[parent].add(i);
            }
        }

        int min = solve(root); // 루트부터 탐색 시작
        System.out.println(min);

    }

    // 현재 직원(idx)이 모든 부하 직원에게 뉴스를 전파하는 데 걸리는 시간을 계산하는 함수
    private static int solve(int idx) {

        for(int i=0; i<list[idx].size(); i++) {
            int next = list[idx].get(i);
            // 부하 직원이 뉴스를 전하는 데 걸리는 시간을 재귀적으로 계산하고, dp에 저장
            dp[next] = 1 + solve(next);
        }

        // 부하 직원들을 dp 값을 기준으로 내림차순으로 정렬 (시간이 많이 걸리는 직원부터 처리하기 위해)
        Collections.sort(list[idx], new DepthComp());

        int result = 0; // 현재 직원이 뉴스를 모두 전파하는데 걸리는 시간
        for(int i=0; i<list[idx].size(); i++) {
            int num = list[idx].get(i);
            dp[num] += i; // 부하 직원이 뉴스를 전하는 데 걸리는 시간에 순서에 따른 지연 시간을 추가
            result = Math.max(result, dp[num]);
        }

        return result;
    }

    private static class DepthComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return dp[o2] - dp[o1];
        }
    }

}
