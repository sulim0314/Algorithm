import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, W; // N: 건물의 개수, K: 건물간의 건설 규칙 개수
	static int[] time;
	static int[] indegree;
	static int[] result;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			time = new int[N+1];
			indegree = new int[N+1];
			result = new int[N+1];
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			list = new ArrayList[N+1];
			for(int i=0; i<N+1; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				indegree[b]++;
			}
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			
			solve();
			System.out.println(result[W]);
			
		}
		
	}

	private static void solve() {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			result[i] = time[i];
			
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i);
				result[next] = Math.max(result[cur]+time[next], result[next]);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}

}
