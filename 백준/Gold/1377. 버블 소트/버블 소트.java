import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(br.readLine());
			arr[i][1] = i; 
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		int maxMove = 0;
		for (int i = 0; i < n; i++) {
			maxMove = Math.max(maxMove, arr[i][1] - i);
		}

		System.out.println(maxMove + 1);
	}
	
}
