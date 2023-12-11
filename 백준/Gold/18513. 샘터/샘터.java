import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] sam;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N개의 샘터, K채의 집
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sam = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sam[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			q.offer(sam[i]);
			set.add(sam[i]);
		}
		
		long result = 0;
		int dist = 1;
		
		top:
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				int s = q.poll();
				int right = s + 1;
				int left = s - 1;
				
				// 오른쪽 위치에 집 짓기
				if(!set.contains(right)) {
					q.offer(right);
					result += dist;
					set.add(right); // 집 지었음. (visited)같은 것.
					if(--K == 0) break top;
				}
				if(!set.contains(left)) {
					q.offer(left);
					result += dist;
					set.add(left);
					if(--K == 0) break top;
				}
			}
			dist++;
		}
		System.out.println(result);
	}

}
