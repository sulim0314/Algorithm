package study4;

import java.io.IOException;
import java.util.Scanner;

public class algo0727_11769 {

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine()); //공백단위로 읽어드릴수 있는 라인 추가
//        int c = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음
//        int d = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음
//        System.out.println(c + " " + d);
//
//        st = new StringTokenizer(br.readLine(),","); // , 단위로 읽어드릴수 있는 라인 추가
//        int e = Integer.parseInt(st.nextToken()); //한줄에서 , 단위로 읽음
//        int f = Integer.parseInt(st.nextToken()); //한줄에서 , 단위로 읽음
//        System.out.println(e + " " + f);

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // n = 데이터의 개수
		int m = sc.nextInt(); // m = 줄의 개수
		int S[] = new int[n + 1]; // S = 구간 합을 구할 대상 배열

		for (int i = 1; i <= n; i++) { // ex) 5 4 3 2 1 넣는다면
			S[i] = S[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(); // 몇번째부터 // a[x-1] ~ a[y-1]
			int y = sc.nextInt(); // 몇번째까지 // S[y-1] - S[x-2]
			System.out.println(S[y] - S[x - 1]);
		}

		System.out.println(S[0]); // 아무것도 안 쓰면 0으로 채워짐.

	}

}
