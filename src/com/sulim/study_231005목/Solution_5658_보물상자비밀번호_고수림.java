package com.sulim.study_231005목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_5658_보물상자비밀번호_고수림 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());//TreeSet생성
			
			String line = br.readLine();
			int len = N/4;
			String tmp = line.substring(0, len-1);
			line = line + tmp;
			
			for(int i=0; i<N; i++) {
				String temp = line.substring(i, i+len);
				set.add(temp);
			}
			
			int result = 0;
			int cnt = 1;
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String s = it.next();
				if(cnt == K) {
					String target = s;
					result = Integer.parseInt(target, 16);
					System.out.println("#"+tc+" "+result);
					break;
				}
				cnt++;
			}
		}
		
	}

}

/*
1
12 10
1B3B3B81F75E
 */

/*
5
12 10
1B3B3B81F75E
16 2
F53586D76286B2D8
20 14
88F611AE414A751A767B
24 16
044D3EBA6A647B2567A91D0E
28 11
8E0B7DD258D4122317E3ADBFEA99
*/