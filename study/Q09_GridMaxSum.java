package study;
/*[입력]
첫 줄에 자연수 N이 주어진다 (2<= N <=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가
주어진다
각 자연수는 100을 넘지 않는다
[출력]
최대합을 출력한다
*/
import java.util.*;
public class Q09_GridMaxSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("2이상 50 이하의 N을 입력해주세요 >> ");
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int[] sum = new int[2*N+2];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = (int)(Math.random()*100) + 1;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum[i] += arr[i][j];
				sum[N+i] += arr[j][i];
				if(i == j) {
					sum[2*N] += arr[i][j];
				} else if(i + j == N-1) {
					sum[2*N+1] += arr[i][j];
				}
			}
		}

		Arrays.sort(sum);
		System.out.println(Arrays.toString(sum));
		System.out.println("가장 큰 합 >> "+ sum[2*N+1]);
	}

}
