package Algo;

import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {

		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		int answer = 0;

		// 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			q.add(scoville[i]);
		}

		while (q.peek() < K) {

			if (q.size() < 2) {
				answer = -1;
				break;
			}

			int tmp = q.poll() + q.poll() * 2;
			q.add(tmp);
			answer++;

		}

		System.out.println(answer);

	}

}
