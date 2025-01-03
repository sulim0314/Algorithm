import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int left = 100 - progresses[i];
            int s = speeds[i];
            if(left % s > 0) {
                q.add((left / s) + 1);
                // System.out.println((left / s) + 1);
            } else {
                q.add((left / s));
                // System.out.println((left / s));
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int cnt = 1;
            
            while(q.size() > 0) {
                int peek = q.peek();
                if(peek <= cur) {
                    cnt++;
                    q.poll();
                } else {
                    break;
                }
            }
            
            answerList.add(cnt);
            
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}