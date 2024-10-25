import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long r = (long) times[times.length-1]*n;
        long l = 0;
        long mid = 0;

        while(l <= r) {
            mid = (l + r)/2;
            long people = 0;
            
            for(int time: times) {
                people += mid/time;
            }
            
            if(n <= people) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return answer;
    }
}