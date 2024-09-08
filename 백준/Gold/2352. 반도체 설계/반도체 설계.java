import java.util.*;
import java.io.*;

// 최장 증가 부분 수열
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] pins = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pins[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int pin : pins) {
            if (lis.isEmpty() || lis.get(lis.size() - 1) < pin) {
                lis.add(pin);  // LIS 배열의 마지막 원소보다 크면 추가
            } else {
                // LIS 배열에서 현재 원소가 들어갈 위치를 찾음 (이분 탐색 이용)
                int pos = Collections.binarySearch(lis, pin);
                if (pos < 0) pos = -(pos + 1);  // 삽입 위치 계산
                lis.set(pos, pin);  // 기존 원소를 교체하여 LIS 유지
            }
        }

        System.out.println(lis.size());  // 최장 증가 부분 수열의 길이 출력



    }
}
