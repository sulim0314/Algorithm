import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<line.length(); i++) {
			char c = line.charAt(i);
			int tmp = 0;
			
			if(c == '(') {
				st.push(0);
			} else if(c == ')') {
				while(true) {
					int n = st.pop();
					if(n == 0) {
						break;
					}
					tmp += n;
				}
				st.push(tmp);
			} else if(c == 'H') {
				st.push(1);
			} else if(c == 'C') {
				st.push(12);
			} else if(c == 'O') {
				st.push(16);
			} else { // 숫자
				tmp = st.pop();
				tmp *= c - '0';
				st.push(tmp);
			}
		}
		
		int result = 0;
		while(!st.isEmpty()) {
			result += st.pop();
		}
		System.out.println(result);
		
	}

}
