import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(A, B, C));
		
	}

	private static long solve(int a, int b, int c) {

		long result = 1;
		long multiply = a % c;

		while (b > 0) {
			if (b % 2 == 1) {
				result *= multiply;
				result %= c;
			}
			multiply = ((multiply % c) * (multiply % c)) % c;
			b /= 2;
		}

		return result;
	}

}
