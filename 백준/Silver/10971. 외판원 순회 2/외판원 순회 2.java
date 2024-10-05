import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int lastBit;
    static int min = 2_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        lastBit = (1<<N) - 1;
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 1, 0);
        System.out.println(min);

    }

    private static void solve(int cur, int bit, int w) {
        if(bit == lastBit) {
            // 마지막 도시에서 시작 도시로 돌아갈 수 있는지 확인
            if (map[cur][0] != 0) {
                min = Math.min(min, w + map[cur][0]); // 시작 도시로 돌아오는 비용 추가
            }
            return;
        }

        for(int i=0; i<N; i++) {
            if((bit & (1<<i)) == 0) {
                if(map[cur][i] != 0) {
                    solve(i, (bit | (1<<i)), w + map[cur][i]);
                }
            }
        }

    }
}
