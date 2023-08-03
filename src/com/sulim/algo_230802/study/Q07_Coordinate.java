package com.sulim.algo_230802.study;
import java.util.*;

public class Q07_Coordinate implements Comparable<Q07_Coordinate> {
	
    private int x;
    private int y;

    public Q07_Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("좌표 개수를 입력하세요");
        int n = sc.nextInt();
        
        Q07_Coordinate[] coordinates = new Q07_Coordinate[n]; // ★

        System.out.println("좌표를 입력하세요");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinates[i] = new Q07_Coordinate(x, y); // ★
        }

        Arrays.sort(coordinates);
        // Arrays.sort(coordinates, Comparator.reverseOrder());
        
        System.out.println("정렬된 좌표:");
        for (Q07_Coordinate coordinate : coordinates) {
            System.out.println(coordinate);
        }
    }

    /*Arrays.sort() 메서드를 호출할 때, ★
     * 해당 배열의 요소 타입이 Comparable 인터페이스를 구현한 경우에는 
     * compareTo() 메서드를 내부적으로 호출하여 요소들을 정렬한다.*/
    
    /*Integer.compare(a, b)는 a와 b를 비교하여 결과를 반환하는 정적 메서드. ★
     * a가 b보다 작으면 음수를 반환. 음수(-1)를 반환하면 그대로 둔다
     * a가 b와 같으면 0을 반환. 
     * a가 b보다 크면 양수를 반환.양수(1)를 반환하면 두 값의 위치를 교환함
     * */
    
    @Override
    public int compareTo(Q07_Coordinate o) {
        // x 좌표를 기준으로 비교하고, x 좌표가 같다면 y 좌표를 기준으로 비교.
        if (this.x == o.x) {
            return Integer.compare(o.y, this.y); // 반대로 비교하여 내림차순으로 정렬.
        }
        return Integer.compare(o.x, this.x); // 반대로 비교하여 내림차순으로 정렬.
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    /* System.out.println() 메서드는 객체를 출력할 때 
     해당 객체의 toString() 메서드를 자동으로 호출하여 문자열로 변환한 후 출력한다. 
     따라서 System.out.println(coordinate)를 호출하면 
     coordinate 객체의 toString() 메서드가 내부적으로 호출되어 좌표를 문자열로 변환하게 된다. 
    */
    
}