import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		long n1 = sc.nextLong();
		long n2 = sc.nextLong();

		long gcd = getGcd(n1, n2);

		for (int i = 0; i < gcd; i++) {
			sb.append(1);
		}

		System.out.println(sb);
	}

	// 최대공약수를 구하는 유클리드 호제법 함수
	private static long getGcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

}
