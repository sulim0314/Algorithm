import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] num;
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		num = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			num[to]++;
		}
		
		sort();
		
	}

	private static void sort() {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		// 선행 정점을 갖지 않은 정점을 큐에 넣기.
		for(int i=1; i<=N; i++) {
			if(num[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int N = q.poll();
			System.out.print(N+" ");
			
			for(int j=0; j<list[N].size(); j++) {
				int next = list[N].get(j);
				num[next]--;
				
				if(num[next] == 0) {
					q.add(next);
				}
				
			}
			
		}
		
	}

}
