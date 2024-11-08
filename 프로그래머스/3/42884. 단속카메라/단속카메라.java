import java.util.*;

class Solution {
    
    static class Info implements Comparable<Info> {
        int s, e;
        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.e, o.e); // 나가는 지점 기준 정렬
        }
    }
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int[] r: routes) {
            pq.add(new Info(r[0], r[1]));
        }
        
        int min = -30000;
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            
            if(min >= cur.s && min <= cur.e) {
                continue;
            }
            
            min = cur.e;
            answer++;
        }

        
        return answer;
    }
}