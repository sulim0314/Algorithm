import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] data, num;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		data = new int[N];
		num = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		per(0);
		System.out.println(sb.toString());
		
	}

	private static void per(int cnt) {

		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			num[cnt] = data[i];
			visited[i] = true;
			per(cnt+1);
			visited[i] = false;
		}
		
	}

}
