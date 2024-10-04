import java.util.*;
import java.io.*;

// 비트마스크 & DP
public class Main {

    static int N;
    static int[][] map, dp;
    static final int INF = 2_000_000_000;
    static int min = INF;
    static int lastBit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 모든 도시를 방문한 상태를 비트마스크로 설정
        // 예: N이 4일 경우 lastBit는 1111(2진수), 즉 (1<<N) - 1로 계산됨.
        lastBit = (1<<N) - 1; // (1 << N)은 2의 N제곱, 즉 2^N

        dp = new int[N][lastBit]; // dp 배열은 [도시 번호][방문 상태(비트마스크)]로 구성
        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0번 도시에서 시작하고, 0번 도시는 이미 방문한 상태(비트마스크 1)
        System.out.println(check(0,1));

    }

    // x: 현재 도시, flag: 현재까지 방문한 도시를 비트마스크로 표시
    private static int check(int x, int flag) {

        // 모든 도시 방문 완료
        if(flag == lastBit) {
            // 마지막 도시에서 출발 도시(0번 도시)로 돌아갈 수 있는지 확인
            if(map[x][0] == 0) {
                return INF;
            } else {
                return map[x][0];
            }
        }

        // 이미 방문했다면,
        if(dp[x][flag] != -1) {
            return dp[x][flag];
        }

        dp[x][flag] = INF;

        for(int i=0; i<N; i++) {

            // next로 i번째 도시 방문
            int next = flag | (1<<i); // 현재 방문한 도시들에 i번째 도시를 추가

            // 경로가 없거나, 이미 방문했을 경우, continue
            if(map[x][i] == 0 || (flag & (1<<i)) != 0) {
                continue;
            }

            //  i번째 도시를 방문한 후 최소 비용을 업데이트
            dp[x][flag] = Math.min(dp[x][flag], check(i, next) + map[x][i]);
        }

        return dp[x][flag];
    }


}
