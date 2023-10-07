package com.sulim.LIS;
/**
 * - 해당 원소를 끝으로 하는 LIS의 길이를 DP테이블에 저장
 * - 시간 복잡도 O(N^2)
 */

public class LIS2 {
    public static void main(String[] args) {
        int[] a = { 3, 2, 6, 4, 5, 1 };
        int n = a.length;

        // i번째 원소를 끝으로 하는 LIS의 길이를 저장하는 배열
        int[] lis = new int[n];

        int[] path = new int[n]; // lis에서 이진 수열의 index를 저장하는 배열
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            // 초기값 설정, 일단 현재 수만
            lis[i] = 1;
            path[i] = -1; // 현재 수에 앞에 없을 때를 위해 초기 값을 -1로 설정 한다.

            // 맨 처음 원소부터, 현재 수를 시작으로 하는 LIS의 길이 중 가장 큰 수에 현재 수를 붙이기
            for (int j = 0; j < i; j++) {
                // i번째 수보다 작아서 i를 끝으로 세울 수 있고
                if (a[j] < a[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1; // 현재 수에 앞에 오는 lis 길이 갱신
                    path[i] = j; // 현재 수에 앞에오는 수가 변경했으므로 index를 갱신해준다.
                }
            }
            if (lis[max] < lis[i]) {
                max = i;
            }
        }

        System.out.println("최장 증가 수열의 길이 " + lis[max] );
        StringBuilder sb = new StringBuilder(lis[max] * 2);
        int idx = max; // 4
        while (idx > -1) {
            sb.append(a[idx] + " ");
            idx = path[idx];
        }
        System.out.println(sb.reverse().toString()); // 5 
    }
}