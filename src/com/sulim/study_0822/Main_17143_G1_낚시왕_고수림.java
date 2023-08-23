package com.sulim.study_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_17143_G1_낚시왕_고수림 {

    static int R, C; // R행 C열
    static int M; // 상어 수
    static int[][] map;
    static int result;
    static ArrayList<shark> list;
    static int tmp, first, second;
    static ArrayList<info> killIdx;
    
    static class info {
        int idx;
        int r;
        public info(int idx, int r) {
            super();
            this.idx = idx;
            this.r = r;
        }
    }
    
    static class shark {
        int r,c; // 위치
        int s;      // 속력
        int d;   // 방향
        int z;   // 크기
        int flag;
        public shark(int r, int c, int s, int d, int z, int flag) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.flag = flag;
        }
    }
    
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        list = new ArrayList<>();

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken())-1;
            int tmp2 = Integer.parseInt(st.nextToken())-1;
            int tmp3 = Integer.parseInt(st.nextToken());
            int tmp4 = Integer.parseInt(st.nextToken());
            int tmp5 = Integer.parseInt(st.nextToken());
            
            list.add(new shark(tmp1,tmp2,tmp3,tmp4,tmp5,0));
            map[tmp1][tmp2] = i; // map에 1부터 M까지 들어감.
        }
        
        for(int i=0; i<C; i++) { // C초동안 일어나는 일
        	
            kill(i); // 낚시로 죽여
            
            for(int j=0; j<list.size(); j++) {
                if(list.get(j).flag == 0) {
                    move(j); // 물고기들 움직여, 부딪혀서 죽어
                }
            }
            
            map = new int[R][C];
            
            for(int j=0; j<list.size(); j++) {
                if(list.get(j).flag == 0) {
                    update(j); 
                }
            }
            
        }

        System.out.println(result);
        
    }

    private static void kill(int line) {

        killIdx = new ArrayList<>();
        
        // 리스트의 마지막부터 처음까지 찾아보면서 line과 똑같으면 죽이기.
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).c == line && list.get(i).flag == 0) {
                killIdx.add(new info(i,list.get(i).r));
            }
        }
        int idx=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<killIdx.size(); i++) {
            if(min > killIdx.get(i).r) {
                idx = killIdx.get(i).idx;
                min = killIdx.get(i).r;
            }
        }
        
        if(idx != -1) {
            map[list.get(idx).r][list.get(idx).c] = 0; // map에서 없애기.
            result += list.get(idx).z; // 상어 크기 더해주기.
            list.get(idx).flag = 1; // 죽음 표시
            newMap();
        }
        
    }

    private static void newMap() {
        map = new int[R][C];
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).flag == 0) { // 살아있을 때
                map[list.get(i).r][list.get(i).c] = i+1;
            }
        }
    }

    private static void move(int fishIdx) {
        
        // map 업데이트(지우기)
        map[list.get(fishIdx).r][list.get(fishIdx).c] = 0;
        
        // list 업데이트
        // 상
        if(list.get(fishIdx).d == 1) {
            int val = 2;
            if(list.get(fishIdx).r - list.get(fishIdx).s > 0) {
            	tmp = list.get(fishIdx).r - list.get(fishIdx).s;
            } else {
            	tmp = list.get(fishIdx).s - list.get(fishIdx).r;
            	val = 1;
            	list.get(fishIdx).d = 2;
            }
            
            first = tmp/(R-1); // 몫
            second = tmp%(R-1); // 나머지
            
            // 만약 first가 홀수라면, 방향 바꾸기 2로, 반대방향에서 나머지만큼.
            // 짝수라면 그대로 1, 똑같은 방향으로 나머지만큼.
            if(first % 2 == 1) { // 홀수
                list.get(fishIdx).d = val;
                list.get(fishIdx).r = (R-1)-second;
            } else { // 짝수
                list.get(fishIdx).r = second;
            }
            
        } else if(list.get(fishIdx).d == 2) { // 하
            
            tmp = list.get(fishIdx).r + list.get(fishIdx).s;
            first = tmp/(R-1); // 몫
            second = tmp%(R-1); // 나머지
            
            // 만약 first가 홀수라면, 방향 바꾸기 1로, 반대방향에서 나머지만큼.
            // 짝수라면 그대로 2, 똑같은 방향으로 나머지만큼.
            if (first % 2 == 1) { // 홀수 방향바꾸기
                list.get(fishIdx).d = 1;
                list.get(fishIdx).r = (R-1)-second;
            } else { // 짝수 그대로
                list.get(fishIdx).r = second;
            }
            
        } else if(list.get(fishIdx).d == 3) { // 우
            
            tmp = list.get(fishIdx).c + list.get(fishIdx).s;
            first = tmp/(C-1); // 몫
            second = tmp%(C-1); // 나머지
            
            // 만약 first가 홀수라면, 방향 바꾸기 1로, 반대방향에서 나머지만큼.
            // 짝수라면 그대로 2, 똑같은 방향으로 나머지만큼.
            if (first % 2 == 1) { // 홀수 방향바꾸기
                list.get(fishIdx).d = 4;
                list.get(fishIdx).c = (C-1)-second;
            } else { // 짝수 그대로
                list.get(fishIdx).c = second;
            }
            
        } else if(list.get(fishIdx).d == 4) { // 좌
            int val = 3;
            if(list.get(fishIdx).c - list.get(fishIdx).s > 0) {
            	tmp = list.get(fishIdx).c - list.get(fishIdx).s;
            } else {
            	tmp = list.get(fishIdx).s - list.get(fishIdx).c;
            	val = 4;
            	list.get(fishIdx).d = 3;
            }
            
            first = tmp/(C-1); // 몫
            second = tmp%(C-1); // 나머지
            
            // 만약 first가 홀수라면, 방향 바꾸기 1로, 반대방향에서 나머지만큼.
            // 짝수라면 그대로 2, 똑같은 방향으로 나머지만큼.
            if (first % 2 == 1) { // 홀수 방향바꾸기
                list.get(fishIdx).d = val;
                list.get(fishIdx).c = (C-1)-second;
            } else { // 짝수 그대로
                list.get(fishIdx).c = second;
            }
            
        }
        
    }
    
   private static void update(int fishIdx) {
        
        // map 업데이트(넣기)
        // 무언가랑 겹칠 때
        if(map[list.get(fishIdx).r][list.get(fishIdx).c] != 0) {
            int tmpIdx = map[list.get(fishIdx).r][list.get(fishIdx).c] - 1;
            if(list.get(fishIdx).z > list.get(tmpIdx).z) {
                list.get(tmpIdx).flag = 1;
                map[list.get(fishIdx).r][list.get(fishIdx).c] = fishIdx + 1;
            } else {
                list.get(fishIdx).flag = 1;
            }
        } else { // 이미 맵에 아무것도 없을 때
            map[list.get(fishIdx).r][list.get(fishIdx).c] = fishIdx + 1;
        }
        
        
    }
}