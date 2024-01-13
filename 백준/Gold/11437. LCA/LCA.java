import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static int[] parents;
	static int[] dep;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		parents = new int[N+1];
		dep = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1,1,0);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(LCA(a,b));
		}
	}

	private static int LCA(int a, int b) {
		
		int ad = dep[a];
		int bd = dep[b];
		
		while(ad > bd) {
			a = parents[a];
			ad--;
		}
		
		while(bd> ad) {
			b = parents[b];
			bd--;
		}
		
		while(a!=b) {
			a = parents[a];
			b = parents[b];
		}
		
		return a;
	}

	private static void dfs(int cur, int d, int p) {

		dep[cur] = d;
		parents[cur] = p;
		
		for(int i=0; i<list[cur].size(); i++) {
			int next = list[cur].get(i);
			if(next != p) {
				dfs(next, d+1, cur);
			}
		}
		
		
	}

}
