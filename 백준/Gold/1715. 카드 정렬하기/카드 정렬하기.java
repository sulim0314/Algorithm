import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N 묶음 합치는 효율적인 방법 (합이 최소)

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(br.readLine());
			minHeap.offer(card);
		}

		int result = 0;

		while (minHeap.size() > 1) {
			int sum = minHeap.poll() + minHeap.poll();
			result += sum;
			minHeap.offer(sum);
		}

		System.out.println(result);
	}
}
