package day02;
import java.util.*;

public class Q18_DayOfYear {
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		int no = 0;
		do {
			System.out.print("년도: ");
			int year = sc.nextInt();
			System.out.print("월 : ");
			int month = sc.nextInt();
			System.out.print("일 : ");
			int day = sc.nextInt();
			
			int totalDays = getDayOfYear(year, month, day);
			
			System.out.printf("%d년 %d일째 입니다%n" , year, totalDays);
			
			System.out.println("한번 더 하시겠습니까? [1. yes / 2. no]");
			no = sc.nextInt();
		} while(no == 1);
		System.out.println("Bye Bye~~");
	} //---------------------------------------
	
	public int getDayOfYear(int year, int month, int day) {
		int total = 0;
		int[] mArr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(year%4 == 0) { // 윤년 구하기
			mArr[2] = 29;
			if(year%100 == 0) { // 윤년 X
				mArr[2] = 28;
			} 
			if(year%400 == 0) { // 윤년
				mArr[2] = 29;
			}
		}
		
		for(int i=1; i<month; i++) {
			System.out.printf("%d월: %d일%n", i, mArr[i]);
			total += mArr[i];
		}
		System.out.printf("%d월: %d일%n", month, day);
		total += day;
		System.out.println("total: "+ total);
		
		return total;
	} //---------------------------------------

	public static void main(String[] args) {
		Q18_DayOfYear app = new Q18_DayOfYear();
		app.input();
		
	}
}



