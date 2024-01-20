import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int next = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			q.add(i+1);
		}
		
		System.out.print("<");
		
		while(q.size() > 1) {
			
			for(int i=0; i<next-1; i++) {
				int temp = q.poll();
				q.add(temp);
			}
			
			System.out.print(q.poll()+", ");
		}
		
		System.out.print(q.poll() + ">");
	}

}
