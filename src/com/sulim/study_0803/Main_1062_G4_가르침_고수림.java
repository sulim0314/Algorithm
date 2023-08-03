package com.sulim.study_0803;

import java.util.Scanner;

public class Main_1062_G4_가르침_고수림 {

	static int N;
	static int K;

	static boolean[] visit = new boolean[26];
	static String[] words;

	static int maxCanRead = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = sc.nextLine();
		}

		visit['a' - 'a'] = true;
		visit['c' - 'a'] = true;
		visit['t' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['n' - 'a'] = true;

		// K가 5보다 작거나 같은 경우, 필수로 선택되는 글자를 제외하고 K-5개를 선택
		pick(0, 0, K - 5);

		System.out.println(maxCanRead);
	}

	private static void pick(int cnt, int start, int remain) {
		if (cnt == remain) {
			int canRead = canCountWords();
			maxCanRead = Math.max(canRead, maxCanRead);
			return;
		}

		for (int i = start; i < 26; i++) {
			// 중복검사
			if (visit[i]) {
				continue;
			}

			visit[i] = true;

			pick(cnt + 1, i + 1, remain);
			visit[i] = false;
		}
	}

	private static int canCountWords() {
		int canRead = 0;

		for (String word : words) {
			boolean canReadWord = true;
			for (char ch : word.toCharArray()) {
				if (!visit[ch - 'a']) {
					canReadWord = false;
					break;
				}
			}

			if (canReadWord) {
				canRead++;
			}
		}

		return canRead;
	}
}
