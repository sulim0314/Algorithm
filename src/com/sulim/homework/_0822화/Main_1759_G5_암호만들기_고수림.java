package com.sulim.homework._0822화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_G5_암호만들기_고수림 {

	static int L,C;
	static String[] input;
	static char[] data;
    static char[] password;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new String[C];
        data = new char[C];
        password = new char[L];
        visit = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken();
            data[i] = input[i].charAt(0);
        }

        Arrays.sort(data); 
        combi(0, 0);

    }

    private static void combi(int cnt, int start) {

        if (cnt == L) {
            int vo = 0; // 모음 개수
            int co = 0; // 자음 개수

            for (char c : password) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vo++;
                } else {
                    co++;
                }
            }

            if (vo >= 1 && co >= 2) { // 조건에 맞을 때
                System.out.println(password);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[cnt] = data[i];
            combi(cnt + 1, i + 1);
        }
    }
}
