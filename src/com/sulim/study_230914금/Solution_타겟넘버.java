package study_230914금;
import java.util.*;

class Solution {
    
    static int n;
    static int[] num;
    static int answer;
    static int[] origin;
    static int first;
    
    public int solution(int[] numbers, int target) {
        origin = numbers;
        first = target;
        n = numbers.length;
        num = new int[n];
        make(0);
        System.out.println(answer);
        return answer;
    }
    
    static void make(int cnt) {
        if(cnt == n) {
            //System.out.println(Arrays.toString(num)); 중복순열 다 만들어졌음
            check(num);
            return;
        }
        
        for(int i=0; i<2; i++) {
            num[cnt] = i;
            make(cnt+1);
        }
    }
    
    static void check(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                sum += origin[i];
            } else if(arr[i] == 1) {
                sum -= origin[i];
            }
        }
        if(sum == first) {
            answer++;
        }
    }
}
