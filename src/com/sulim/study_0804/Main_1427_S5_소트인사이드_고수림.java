package com.sulim.study_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1427_S5_소트인사이드_고수림 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] arr = s.split("");
		
		Arrays.sort(arr);

		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
		
		
	}

}
