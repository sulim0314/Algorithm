package day01;

public class Q3_GopTable {

	public static void solution() {

		System.out.println("   |  1  2  3  4  5  6  7  8  9  ");
		System.out.println("---+------------------------------");
		
		for(int i=1; i<=9; i++) {
			System.out.print(" "+ i +" |");
			for(int j=1; j<=9; j++) {
				if(i * j <10) {
					System.out.print("  "+i*j);
				} else {
					System.out.print(" "+i*j);
				}
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		solution();
		
	}

}
