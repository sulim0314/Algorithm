import java.util.*;

class Solution {

    static int[][] dp;
    static final int mod = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        
        // 오른쪽과 아래쪽으로만 움직이기.
        // 최단 경로의 개수를 1,000,000,007 로 나눈 나머지 return..
        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        dp[1][1] = 1;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(dp[i][j] == -1) continue;
                if(dp[i-1][j] > 0) {
                    dp[i][j] += dp[i-1][j] % mod;
                }
                if(dp[i][j-1] > 0) {
                    dp[i][j] += dp[i][j-1] % mod;
                }
            }
        }
        
        return dp[n][m] % mod;
    }
}