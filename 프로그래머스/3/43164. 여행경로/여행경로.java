import java.util.*;

class Solution {
    
    static String[] answer;
    static boolean[] visited;
    static int N;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new String[N+1];
        visited = new boolean[N];
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        go("ICN", "ICN", tickets, 0);
        
        return answer;
    }
    
    private static void go(String cur, String path, String[][] tickets, int cnt) {
        
        if(cnt == N) {
            if (answer[0] == null || comparePaths(answer, path.split(" "))) {
                answer = path.split(" ");
            }
            return;
        }
        
        for(int i=0; i<N; i++) {
            if(!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                go(tickets[i][1], path+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
        
    }
    
    private static boolean comparePaths(String[] currentAnswer, String[] newPath) {
        
        for (int i = 0; i < currentAnswer.length; i++) {
            if (!currentAnswer[i].equals(newPath[i])) {
                return currentAnswer[i].compareTo(newPath[i]) > 0;
            }
        }
        
        return false;  // 같을 경우에는 갱신하지 않음
    }
}