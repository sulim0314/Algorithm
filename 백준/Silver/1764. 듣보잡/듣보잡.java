import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hm.get(s) != null) {
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
