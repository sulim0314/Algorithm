import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        StringTokenizer st;
        int[] answer = new int[2];
        
        // 최소, 최대 따로 담기
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String first = st.nextToken();
            
            if(first.equals("I")) {
                int next = Integer.parseInt(st.nextToken());
                pq1.add(next);
                pq2.add(next);
            
            } else if(first.equals("D")) {
                int next = Integer.parseInt(st.nextToken());
                
                if(next == 1) {
                    if(pq2.isEmpty()) continue;
                    int n = pq2.poll();
                    pq1.remove(n);
                } else {
                    if(pq1.isEmpty()) continue;
                    int n = pq1.poll();
                    pq2.remove(n);
                }
            }
        }
        
        if(!pq1.isEmpty() && !pq2.isEmpty()) {
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }
}