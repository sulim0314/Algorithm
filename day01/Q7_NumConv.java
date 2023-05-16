package day01;

import java.util.Scanner;

public class Q7_NumConv {

    public static void main(String[] args) {
        char[] arr = new char[32]; // int 크기 => 32
        Scanner sc = new Scanner(System.in);
        System.out.print("정수(양수) 입력 >> ");
        int num = sc.nextInt();
        System.out.print("몇 진수로 변환할까요? (2~36) >> ");
        int radix = sc.nextInt();
        
        solution(num, radix, arr);

        System.out.print("변환 결과: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                System.out.print(arr[i]);
            }
        }
    }

    public static void solution(int num, int radix, char[] arr) {
        int index = 0;
        while (num > 0) {
            int remainder = num % radix;
            if (remainder < 10) {
                arr[index++] = (char) ('0' + remainder);
            } else {
                arr[index++] = (char) ('A' + remainder - 10);
            }
            num /= radix;
        }
    }

}