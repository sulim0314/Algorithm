import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int height;
	int num;
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<Top> s = new Stack<>();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			Top top = new Top();
			top.height = Integer.parseInt(st.nextToken());
			top.num = i+1;
			
			while(!s.isEmpty() && s.peek().height < top.height) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				sb.append(0 + " ");
			} else {
				sb.append(s.peek().num + " ");
			}
			
			s.push(top);

		}
		System.out.print(sb);
		
		br.close();
	}

}