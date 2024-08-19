import java.util.*;
import java.io.*;

// 카누선수, 이분탐색
public class Main {

    static int k, n;
    static long[] tmp;
    static long[] arr12, arr34;
    static long abs, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        long weight;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken()); // 합해서 돼야 할 숫자
            n = Integer.parseInt(st.nextToken());

            tmp = new long[n];
            // 1반 학생들의 몸무게
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tmp[i] = Long.parseLong(st.nextToken());
            }
            // 2반 학생들의 몸무게 추가 입력 (1반, 2반 합쳐서 나올 수 있는 경우의 수 모두)
            arr12 = new long[n * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                weight = Long.parseLong(st.nextToken());
                for (int j = 0; j < n; j++) {
                    arr12[n * i + j] = weight + tmp[j];
                }
            }
            // 3반 학생들의 몸무게
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tmp[i] = Long.parseLong(st.nextToken());
            }
            // 4반 학생들의 몸무게 추가 입력
            arr34 = new long[n * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                weight = Long.parseLong(st.nextToken());
                for (int j = 0; j < n; j++) {
                    arr34[n * i + j] = weight + tmp[j];
                }
            }

            Arrays.sort(arr34);

            abs = Math.max(k - 3, 40_000_001 - k);
            for(int i=0; i<n*n; i++) {
                solve(arr12[i]);
                if(result == k) break;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void solve(long num) {
        int start = 0;
        int end = n*n -1;
        int mid;
        long tmp;
        while(start <= end) {
            mid = (start + end)/2;
            tmp = arr34[mid] + num - k;

            if(abs > Math.abs(tmp)) {
                abs = Math.abs(tmp);
                result = arr34[mid] + num;
            } else if(abs == Math.abs(tmp) && tmp < 0) {
                result = arr34[mid] + num;
            }

            if(arr34[mid] + num < k) {
                start = mid + 1;
            } else if(arr34[mid] + num == k) {
                return;
            } else {
                end = mid - 1;
            }

        }
    }
}
