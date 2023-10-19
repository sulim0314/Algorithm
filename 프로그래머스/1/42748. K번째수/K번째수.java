import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList();
        
        for(int i=0; i<commands.length; i++) {
            
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                list.add(array[j]); // 5 2 6 3
            }
            
            Collections.sort(list); // 2 3 5 6
            answer[i] = list.get(commands[i][2]-1); // 5
            list.removeAll(list); // 비우기
        }

        return answer;
    }
}