import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[N][0] = arr[0][0];
		arr[N][1] = arr[0][1];
		
		long sum1 = 0;
		long sum2 = 0;
		for(int i=0; i<N; i++) {
			sum1 += (long) arr[i+1][0] * arr[i][1];
			sum2 += (long) arr[i][0] * arr[i+1][1];
		}
		
		long sum = Math.abs(sum1 - sum2);
		String area = String.format("%.1f", sum/2.0);
		System.out.println(area);
	}

}
