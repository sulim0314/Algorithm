package com.sulim.study_0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_S1_Z_고수림 {

    static int N;
    static int result = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solve(r, c, (1 << N));

        System.out.println(result);
    }

    private static void solve(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int area = half * half;

        if (r < half && c < half) {
            solve(r, c, half);
            
        } else if (r < half && c >= half) {
        	result += area;
            solve(r, c - half, half);
            
        } else if (r >= half && c < half) {
        	result += 2 * area;
            solve(r - half, c, half);
            
        } else {
        	result += 3 * area;
            solve(r - half, c - half, half);
        }
    }
}