class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int r = 2*w + 1;
        
        int idx = 1;
        int start = 0;
        int end = 0; 
        int diff = 0;
        for(int i=0; i<stations.length; i++) {
            int cur = stations[i];
            
            start = cur - w;
            if(start < 1) {
                start = 1;
            }
            end = cur + w;
            if(end > n) {
                end = n;
            }
            
            diff = start - idx;

            if(diff % r > 0) {
                answer += diff / r + 1;
            } else {
                answer += diff / r;
            }

            idx = end + 1;
            
        }
        
        if(end < n) {
            diff = n - end;
            if(diff % r > 0) {
                answer += diff / r + 1;
            } else {
                answer += diff / r;
            }
        }
        
        
        
        return answer;
    }
}