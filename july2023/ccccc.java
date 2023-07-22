package july2023;

import java.util.ArrayList;
import java.util.Stack;

public class ccccc {
	int answer = 0;

	public int solution(String s) {

		char[] charArray = s.toCharArray();
		ArrayList<Character> arrayList = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			arrayList.add(charArray[i]);
		}
		check(arrayList);
		for (int i = 0; i < charArray.length; i++) {
			char temp = arrayList.get(0);
			arrayList.remove(0);
			arrayList.add(temp);
			check(arrayList);
		}
		return answer;
	}

	public void check(ArrayList<Character> list) {

		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.push(list.get(i));
			} else {
				if (list.get(i) == '(' && stack.peek() == ')') {
					stack.pop();
					if (stack.isEmpty()) {
						count++;
					}
				} else if (list.get(i) == '[' && stack.peek() == ']') {
					stack.pop();
					if (stack.isEmpty()) {
						count++;
					}
				} else if (list.get(i) == '{' && stack.peek() == '}') {
					stack.pop();
					if (stack.isEmpty()) {
						count++;
					}
				} else {
					stack.add(list.get(i));
				}
			}
		}

		if (stack.isEmpty()) {
			answer = count;
		}
	}

}