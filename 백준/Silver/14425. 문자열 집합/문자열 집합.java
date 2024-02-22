import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			hm.put(s, 1);
		}
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(hm.containsKey(s)) {
				cnt++;
			}
		}

		System.out.println(cnt);
		
	}

}
