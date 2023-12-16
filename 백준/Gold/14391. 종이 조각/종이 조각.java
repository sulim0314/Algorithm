import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		int result = 0;
		int max = 1<<(N*M); // N*M 자리까지 
		
		for(int s=0; s<max; s++) {
			int sum = 0;
			
			// 가로는 0
			for(int i=0; i<N; i++) {
				int cur = 0;
				for(int j=0; j<M; j++) {
					int k = i*M + j;
					if( (s&(1<<k)) == 0 ) {
						cur *= 10;
						cur += map[i][j];
					} else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			
			// 세로는 1
			for(int j=0; j<M; j++) {
				int cur = 0;
				for(int i=0; i<N; i++) {
					int k = i*M + j;
					if( (s&(1<<k)) != 0) {
						cur *= 10;
						cur += map[i][j];
					} else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
		
	}

}
