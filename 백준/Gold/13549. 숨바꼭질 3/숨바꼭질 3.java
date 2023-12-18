import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info implements Comparable<Info> {
		int to, w;
		public Info(int to, int w) {
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int N, K;
	static boolean[] visited;
	static int max = 100000;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[max+1];
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(N, 0));
		
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			if(cur.to == K) {
				min = Math.min(min, cur.w);
			}
			
			if(!visited[cur.to]) {
				visited[cur.to] = true;
				
				if(0<=cur.to-1 && !visited[cur.to-1]) pq.add(new Info(cur.to-1, cur.w+1));
				if(cur.to+1<=max && !visited[cur.to+1]) pq.add(new Info(cur.to+1, cur.w+1));
				if(cur.to*2<=max && !visited[cur.to*2]) pq.add(new Info(cur.to*2, cur.w));
			}
		}
		
		System.out.println(min);
	}

}
