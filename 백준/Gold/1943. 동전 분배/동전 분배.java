import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 3;
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];  // 동전의 종류 저장
            int[] counts = new int[N];  // 각 동전의 개수 저장

            int total = 0;
            boolean[] dp = new boolean[100_001];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                coins[i] = Integer.parseInt(st.nextToken());  // 동전의 가치
                counts[i] = Integer.parseInt(st.nextToken());  // 해당 동전의 개수
                total += coins[i] * counts[i];  // 동전들의 총합 계산
            }

            // 총합이 홀수이면 반으로 나눌 수 없으므로 바로 0 출력
            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            } else if(dp[total / 2]) {
                System.out.println(1);
                continue;
            }

            int target = total / 2;  // 총합을 반으로 나눈 값
            dp[0] = true;
            for (int i = 0; i < N; i++) {
                int coin = coins[i];  // 현재 동전의 가치
                int count = counts[i];  // 현재 동전의 개수

//                // 기존 DP 배열을 사용해 새로운 값을 갱신하기 위해 역순으로 처리
//                for (int j = target; j >= 0; j--) {
//                    // 해당 동전의 개수를 하나씩 소모하면서 DP 갱신
//                    for (int k = 1; k <= count; k++) {
//                        if (j - k * coin >= 0 && dp[j - k * coin]) {
//                            dp[j] = true;
//                        }
//                    }
//                }

                // 동전의 개수를 배수로 나누어 처리하는 방법
                for (int k = 1; count > 0; k *= 2) {
                    int use = Math.min(k, count);  // 사용할 수 있는 동전 개수는 2의 배수로 처리
                    count -= use;

                    // dp 배열을 역순으로 갱신, 배수로 처리된 개수만큼 사용
                    for (int j = target; j >= coin * use; j--) {
                        if (dp[j - coin * use]) {
                            dp[j] = true;
                        }
                    }
                }

            }

            // 반으로 나눈 값을 만들 수 있으면 1 출력, 아니면 0 출력
            if (dp[target]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }




    }

}
