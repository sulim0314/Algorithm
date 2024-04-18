import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer; // 사람 수, 친구관계 수
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		// depth가 5인 것 찾기
		for(int i=0; i<N; i++) {
			check(i, 1);
			if(answer == 1) {
				System.out.println(answer);
				return;
			}
		}
		
		if(answer == 0) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
		
		
	}
	
	public static void check(int start, int depth) {
		
		if(depth == 5) {
			answer = 1;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<list[start].size(); i++) {
			int next = list[start].get(i);
			if(!visited[next]) {
				check(next, depth+1);
			}
		}
		
		visited[start] = false;
		
	}

}
