import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> s = new Stack<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표 (사용 안 함)
            int h = Integer.parseInt(st.nextToken()); // 높이

            // 현재 높이가 스택의 top보다 낮아질 때까지 pop
            while (!s.isEmpty() && s.peek() > h) {
                s.pop();
                result++;
            }

            if (!s.isEmpty() && s.peek() == h) {
                continue;
            }

            s.push(h);
        }

        while(!s.isEmpty()) {
            if(s.peek() > 0) {
                result++;
            }
            s.pop();
        }

        System.out.println(result);
    }
}
