import java.util.*;

class Solution {
    
    static int n;
    static boolean[] check;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        check = new boolean[n];
        
        boolean flag = false;
        
        for(int i=0; i<n; i++) {
            if(words[i].equals(target)) {
                flag = true;
                break;
            }
        }
        
        if(!flag) {
            answer = 0;
            // System.out.println("0밖에 없음다");
            return answer;
        }
        
        go(begin, 0, target, words);
    
        return answer;
    }
    
    private static void go(String s, int cnt, String target, String[] words) {
        
        if(s.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0; i<n; i++) {
            
            if(check[i]) continue;
            
            int diff = 0;
            
            // 같은 위치에서 한 글자만 다른지 확인
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
            }
            
            if(diff == 1) {
                check[i] = true;
                go(words[i], cnt+1, target, words);
                check[i] = false;
            }
        }
        
    }
}