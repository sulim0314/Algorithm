import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	static int N, M, X;
	static ArrayList<Info>[] list, reverseList;
	static boolean[] visited;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;

		list = new ArrayList[N];
		reverseList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Info(to, w));
			reverseList[to].add(new Info(from, w));
		}
		
		int[] dist1 = dijk(list); // X에서 i
		int[] dist2 = dijk(reverseList); // i에서 X
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int temp = dist1[i] + dist2[i];
			max = Math.max(max, temp);
		}
		
		System.out.println(max);
		
	}

	private static int[] dijk(ArrayList<Info>[] a) {

		int[] dist = new int[N];
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		dist[X] = 0;
		pq.add(new Info(X, 0));
		
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			
			if(!visited[cur.to]) {
				visited[cur.to] = true;
				
				for(int i=0; i<a[cur.to].size(); i++) {
					Info next = a[cur.to].get(i);
					
					if(dist[next.to] > dist[cur.to] + next.w) {
						dist[next.to] = dist[cur.to] + next.w;
						pq.add(new Info(next.to, dist[next.to]));
					}
				}
			}
		}
		
		return dist;
	}

}
