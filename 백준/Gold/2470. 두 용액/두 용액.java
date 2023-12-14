import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] data;
	static int min, a, b;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		data = new int[N];
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
 		}
		Arrays.sort(data);
		
		min = Integer.MAX_VALUE;
		solve();
		
		System.out.println(a+" "+b);
	}


	private static void solve() {

		int start = 0;
		int end = N-1;
		
		while(start < end) {
			if(min > Math.abs(data[start] + data[end])) {
				a = data[start];
				b = data[end];
				min = Math.abs(data[start] + data[end]);
			}
			
			if(data[start] + data[end] > 0) {
				end--;
			} else {
				start++;
			}
		}
		
	}

}
