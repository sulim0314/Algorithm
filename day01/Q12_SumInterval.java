package day01;
/*https://www.acmicpc.net/problem/11660
4 3
 
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7

2 2 3 4
3 4 3 4
1 1 4 4
 * */
import java.util.*;

public class Q12_SumInterval {

	static Scanner sc = new Scanner(System.in); 
	
	public static int[] solution(int N, int M) {
		int[][] arr = new int[N+1][N+1];
		int[][] newArr = new int[N+1][N+1];
		int[] answer = new int[M];
		
		// 1. arr 만들기
		// 2. newArr 만들기
		
		System.out.print("원하는 표를 작성해주세요 >> ");
		
		for(int i=1; i<=N; i++) {
			String[] tmp = sc.nextLine().split(" "); // 1 2 3 4
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(tmp[j-1]);
				newArr[i][j] = newArr[i-1][j] + newArr[i][j-1] - newArr[i-1][j-1] + arr[i][j];
			}
		}

        // 3. 답 구하기
		System.out.print("원하는 구간을 작성해주세요 >> ");
		for(int i=0; i<M; i++) {
			String[] tmp = sc.nextLine().split(" "); // 2 2 3 4 / 1 1 4 4
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);
			int d = Integer.parseInt(tmp[3]);
			
			answer[i] = newArr[c][d] - newArr[a-1][d] - newArr[c][b-1] + newArr[a-1][b-1]; // 원래 식
		}
		
		return answer;	
	} // ---------------------------

	
	public static void main(String[] args) {
		
		System.out.print("표의 크기와 구할 횟수를 입력해주세요 >> "); // 4 3
		String[] nm = sc.nextLine().split(" ");
		
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		System.out.println(Arrays.toString(solution(N,M)));

	
	}
}


/*
 * public class Q12_SumInterval {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("N과 M을 입력하세요");
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int [][]arr=new int[N+1][N+1];
		int [][]dp=new int[N+1][N+1];
		
		//데이터 입력받아 arr에 저장하고
		//구간합 구해서 dp에 저장하기=> 구간합 테이블
		System.out.println("데이터를 입력하세요");
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
			}//for----
		}//for-----------------
		System.out.println();
		printArray(arr);		
		printArray(dp);
		
		System.out.println("구간 데이터를 입력하세요");
		for(int i=0;i<M;i++) {
			int sum=0;
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			sum=dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
			System.out.println("\n"+sum);
		}
	

	}//----------------------------
	
	public static void printArray(int[][] arr) {
		for(int[] a:arr) {
			for(int b:a) {
				System.out.printf("%3d", b);
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}//----------------------------

}*/
