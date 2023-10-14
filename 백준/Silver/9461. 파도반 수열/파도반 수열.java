import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());

		long[] arr = new long[101];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<=100; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			System.out.println(arr[N]);
		}
		
	}

}
