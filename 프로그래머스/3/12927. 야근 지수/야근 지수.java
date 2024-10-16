import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++) {
            pq.add(works[i]);
        }
        
        for(int i=0; i<n; i++) {
            int cur = pq.poll();
            
            if(cur == 0) {
                answer = 0;
                break;
            }
            
            cur--;
            pq.add(cur);
        }
        
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            answer += Math.pow(cur, 2);
        }
        
        return answer;
    }
}