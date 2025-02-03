import java.util.*;
import java.io.*;

public class Main {

    static int[] arr, rain;
    static int H, W;
    static int[] left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        rain = new int[W];
        left = new int[W];
        right = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        left[0] = arr[0];
        right[W-1] = arr[W-1];

        for(int i=1; i<W; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }

        for(int i=W-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        int result = 0;
        for(int i=0; i<W; i++) {
            rain[i] = Math.min(left[i], right[i]);
            result += rain[i] - arr[i];
        }

        System.out.println(result);


    }

}
