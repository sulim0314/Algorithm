package day01;

public class Q1_Max {

	public static int max2(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

	public static int max3(int a, int b, int c) {
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		return max;
	}

	public static int max4(int a, int b, int c, int d) {
		int max = a;
		if(b > max) {
			max = b;
		}
		if(c > max) {
			max = c;
		}
		if(d > max) {
			max = d;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int a = 50;
		int b = 133;
		int c = 45;
		int d = 82;
		
		System.out.println(max4(a,b,c,d));
		
		
	}

}
