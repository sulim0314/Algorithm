import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] data, num; // nCm : 콤비.. 
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		data = new int[N];
		num = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		
		combi(0,0);
		
	}

	private static void combi(int cnt, int start) {
		
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			num[cnt] = data[i];
			combi(cnt+1, i);
		}
		
		
	}
		

}
