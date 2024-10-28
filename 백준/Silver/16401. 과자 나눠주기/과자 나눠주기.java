import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] sticks = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sticks);

        int left = 1;
        int right = sticks[N-1];
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            for(int i=0; i<N; i++) {
                cnt += sticks[i] / mid;
            }

            if(M <= cnt) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(result);

    }
}
