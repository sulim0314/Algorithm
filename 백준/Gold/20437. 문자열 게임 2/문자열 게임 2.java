import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0) {
            String line = br.readLine();
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            
            if(K == 1) { //k가 1일때
                sb.append("1 1\n");
                continue;
            }
            
            int[] alpha = new int[26];
            for(int i=0; i<line.length(); i++) {
                int idx = line.charAt(i) - 'a';
                alpha[idx]++;
            }
            
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int i=0; i<line.length(); i++) {
                if(alpha[line.charAt(i) - 'a'] < K) continue;
                int cnt = 1;
                
                for(int j=i+1; j<line.length(); j++) {
                    if(line.charAt(i) == line.charAt(j)) {
                        cnt++;
                    }
                    if(cnt == K) {
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
                
            }
            
            if(min == Integer.MAX_VALUE || max == -1) {
                sb.append("-1");
            } else {
                sb.append(min).append(" ").append(max);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);

    }
}
