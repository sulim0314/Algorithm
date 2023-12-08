import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[][] arr;
	static long[] arr1, arr2;
	static long answer;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new long[N][4];
		arr1 = new long[N*N];
		arr2 = new long[N*N];
		
		for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr1[i*N + j] = arr[i][0] + arr[j][1];
				arr2[i*N + j] = arr[i][2] + arr[j][3];
			}
		}

		Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int left = 0;
		int right = N*N-1;
        
		while(left < N*N && right >= 0) {
			
			if(arr1[left] + arr2[right] < 0) {
				left++;
			} else if(arr1[left] + arr2[right] > 0) {
				right--;
			} else { 					// == 0 일 때
				long leftCnt = 1;
				long rightCnt = 1;
				while(left+1 < N*N && (arr1[left] == arr1[left+1])) {
					leftCnt++;
					left++;
				}
				while(right > 0 && arr2[right] == arr2[right-1]) {
					rightCnt++;
					right--;
				}
				answer += leftCnt * rightCnt;
				left++;
			}
			
		}
		
		System.out.println(answer);
		
	}

}
