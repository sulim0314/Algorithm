package com.sulim.algo_230802.july2023;

import java.util.*;

public class bbbbb {
	
	public int solution(int[] people, int limit) {
		
		int answer = 0;
		int left = 0, right = people.length - 1;

		// Array to ArrayList
		ArrayList<Integer> peopleList = new ArrayList<>();
		for (int i = 0; i < people.length; i++)
			peopleList.add(people[i]);

		// sorting
		Collections.sort(peopleList);

		while (left <= right) {
			if (left == right) { 
				answer++;
				break;
			}

			if (peopleList.get(left) + peopleList.get(right) > limit) { 
				right--;
				answer++;
			} else { // 두 명 다 탑승 가능한 경우
				answer++;
				left++;
				right--;
			}

		}
		return answer;
	}
}