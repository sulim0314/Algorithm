package day02;
/*Q14. 소수 구하기
0~1000 이하의 정수 중 소수를 구하여 출력하시오
 * */
public class Q14_PrimeNum {

	public static void main(String[] args) {
		int cnt = 0;
		
		for(int num=2; num<=1000; num++) {
			
			for(int i=2; i<=num; i++) {
				cnt++;
				if(num == i) {
					System.out.println(num);
				}
				if(num%i == 0) {
					break;
				}
			} // for

		}// for
		System.out.println("수행횟수: " + cnt);

	}
}
