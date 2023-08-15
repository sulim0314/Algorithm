package com.sulim.study_0814.group;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_G4_카드정렬_스터디 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N 묶음 합치는 효율적인 방법 (합이 최소)

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(br.readLine());
			pq.offer(card);
		}

		int result = 0;

		while (pq.size() > 1) {
			int sum = pq.poll() + pq.poll();
			result += sum;
			pq.offer(sum);
		}

		System.out.println(result);
	}
}
