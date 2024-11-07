import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        // 자연수 n개로 이루어진 집합, 합은 s
        // 인데, 각 원소의 곱이 최대.
        
        if(n > s) {
           return new int[]{-1}; 
        }
        
        int[] answer = new int[n];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = s/n;
        }
        
        int idx = n-1;
        for(int i=0; i<s%n; i++) {
            answer[idx]++;
            idx--;
        }
        
        return answer;
    }
}