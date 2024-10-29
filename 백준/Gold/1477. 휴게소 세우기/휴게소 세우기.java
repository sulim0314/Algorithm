import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+2];

        st = new StringTokenizer(br.readLine());
        arr[0] = 0; // 처음
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N+1] = len; // 마지막

        Arrays.sort(arr);

        int left = 1;
        int right = len - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            // 인접한 두 휴게소의 거리를 mid로 나눠서 휴게소 몇 개 필요?
            for(int i=1; i<arr.length; i++) {         // ex) 휴게소 간의 거리가 100이고 mid가 30이라면
                sum += (arr[i] - arr[i-1] - 1) / mid; // 최대 간격이 30을 넘지 않게 하기 위해 이 간격 내에 3개의 휴게소가 더 필요
            }

            if(sum > M) { // 많이 설치할 수 있으니, 간격(mid)을 키워야 함.
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 가능한 값 중 최소값은 left, 최대값은 right
        System.out.println(left);

    }
}
