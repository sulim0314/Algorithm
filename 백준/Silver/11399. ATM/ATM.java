import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] data;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		data = new int[n];
		
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		
		int sum = 0;
		int total = 0;
		for(int i=0; i<n; i++) {
			sum += data[i];
			total += sum;
		}
		
		System.out.println(total);
		
	}
}
