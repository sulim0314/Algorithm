import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		long x;
		long y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point a1, a2, b1, b2;
	static long x1, y1, x2, y2, x3, y3, x4, y4;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Point[] points = new Point[4];
		
		st = new StringTokenizer(br.readLine());
		x1 = Long.parseLong(st.nextToken());
		y1 = Long.parseLong(st.nextToken());
		x2 = Long.parseLong(st.nextToken());
		y2 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x3 = Long.parseLong(st.nextToken());
		y3 = Long.parseLong(st.nextToken());
		x4 = Long.parseLong(st.nextToken());
		y4 = Long.parseLong(st.nextToken());
		
		points[0] = new Point(x1, y1);
		points[1] = new Point(x2, y2);
		points[2] = new Point(x3, y3);
		points[3] = new Point(x4, y4);
		
		solve(points);
		
	}

	public static int solve(Point[] p) {

		boolean b = false;
		int answer = 0;
		
		int p123 = CCW(p[0], p[1], p[2]);
		int p124 = CCW(p[0], p[1], p[3]);
		int p341 = CCW(p[2], p[3], p[0]);
		int p342 = CCW(p[2], p[3], p[1]);
		
		int aa = p123 * p124;
		int bb = p341 * p342;
		
		if(aa==0 && bb==0) { // 한 직선 위
			//포함 관계
			if(Math.min(x1, x2)<=Math.max(x3, x4) &&
					Math.min(x3, x4)<=Math.max(x1, x2) &&
					Math.min(y1, y2) <= Math.max(y3, y4) &&
					Math.min(y3, y4) <= Math.max(y1, y2)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else if(aa<=0 && bb<=0) { // 교차
			System.out.println(1);
		} else { 
			System.out.println(0);
		}
		
		return answer;
	}

	public static int CCW(Point p1, Point p2, Point p3) {
		
		long result = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x);
		
		if (result > 0) { // 반시계
			return 1;
		} else if (result < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
}