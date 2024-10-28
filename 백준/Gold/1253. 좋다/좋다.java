import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N <= 2) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        int result = 0;
        for(int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while(left < right) {

                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(arr[i] < sum) {
                    right--;
                } else if(arr[i] == sum) {
                    result++;
                    break;
                } else {
                    left++;
                }
            }

        }

        System.out.println(result);

    }
}
