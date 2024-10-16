import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[] arr = new int[N];
        /*
             7
          [10 15]
          8  1   0
        [18, 16, 15]
        2  7   4   4
      [20  25  20  19]
      4. 5.  2.  6.  5
   [ 24. 30  27  26. 24 ]
        */
        arr[0] = triangle[0][0];
        
        for(int i=1; i<N; i++) {
            
            for(int j=triangle[i].length-1; j>=0; j--) {
                
                if(j == 0) {
                    arr[j] += triangle[i][0];
                    // System.out.println(i +" , "+ j + " => " + arr[j]);
                } else if(j == triangle[i].length -1) {
                    arr[j] = arr[j-1] + triangle[i][j];
                    // System.out.println(i +" , "+ j + " => " +  arr[j]);
                } else {
                    arr[j] = Math.max(arr[j-1]+triangle[i][j], arr[j]+triangle[i][j]);
                    // System.out.println(i +" , "+ j + " => " +  arr[j]);
                }
                
            }
        }
        
        for(int i=0; i<N; i++) {
            // System.out.println(arr[i]);
            answer = Math.max(answer, arr[i]);
        }
        
        return answer;
    }
}