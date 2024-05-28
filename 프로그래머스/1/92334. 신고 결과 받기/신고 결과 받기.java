import java.util.*;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        int n = id_list.length;
        answer = new int[n];
        
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        
        for(int i=0; i<report.length; i++) {
            String[] info = report[i].split(" ");
            String p1 = info[0];
            String p2 = info[1];
            
            if (reportedUser.containsKey(p2)) {
                reportedUser.get(p2).add(p1);
            } else {
                reportedUser.put(p2, new HashSet<>() {{ 
                    add(p1);
                }});
                reportedUser.get(p2).add(p1);
            }
            
        }
        
        for (String p2 : reportedUser.keySet()) {
            HashSet<String> targetList = reportedUser.get(p2);
            if (targetList.size() >= k) {
                Iterator it = targetList.iterator();       
                
                while (it.hasNext()) {
                    String userId = (String) it.next();
                    if (result.containsKey(userId)) {
                        result.put(userId, result.get(userId) + 1);
                    } else {
                        result.put(userId, 1);
                    }
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if (result.get(id_list[i]) == null) {
                answer[i] = 0;
            } else {
                answer[i] = result.get(id_list[i]);
            }
        }
        
        
        
        
        return answer;
    }
}