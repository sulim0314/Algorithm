package com.sulim.LIS;

import java.util.Arrays;

/**
 * DP
 * 시간 복잡도 : NlogN
 * 
 * C[K] 배열
 * - 길이가 K인 증가 수열에 대해서
 *   K- 길이 위치에 올 수 있는 가능한 값 중 가장 작은 값을 저장한다.
 * - 동적 배열 C[k]에 가능한 LIS를 정렬한 상태로 담아 놓는다. ==> binary search를 활용
 *    ==> 모든 수열을 처리한 후에는 C[K]에 저장한 데이터는 LIS일 수도 있지만 아닐 가능성이 더 높다.
 *    ==> LIS를 찾는게 목적이 아닌 LIS의 길이를 찾는게 목적으로
 *         C[K]배열에 저장된 데이터의 길이가 LIS의 길이가 된다.
 *
 */
public class LIS3 {

    public static void main(String[] args) {
        
        int[] a = {4,2,3,1,5,6};
        int n = a.length;
        int[] C = new int[n];
        
        int size = 0;        // LIS 개수이면서 C 배열에 저장할 위치
        
        for(int i=0; i<n; i++) {
            // i번째 원소가 위치할 곳을 B.S로 찾는다.
            // a[i] 원소: 탐색 키 
            // Arrays.binarySearch(배열, 키) => 찾으면 찾은 데이터의 index를 리턴
            //                                못찾은 경우, 마지막까지 찾은 위치 -1 위치가 음수로 전달된다.
            // ==> insert point : -마지막까지 찾은 위치 -1
            int temp = Arrays.binarySearch(C, 0, size, a[i]);
            temp = Math.abs(temp)-1;                // insert할 point
            C[temp] = a[i];                            // 맨 뒤에 추가되거나 기존 위치에 덮어쓰기
            if(temp == size) {                        // 맨 뒤에 추가된 상황
                ++size;                                // size를 증가 시킨다.
            }
            
            
        }
        
        System.out.println(size);
        
        
    }

}