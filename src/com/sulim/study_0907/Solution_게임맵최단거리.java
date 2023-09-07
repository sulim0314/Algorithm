package com.sulim.study_0907;

import java.util.*;
class Solution_게임맵최단거리 {

    static class Info {
        int x, y, count;
        public Info(int x, int y, int count) {
            super();
            this.x = x;
            this.y = y;
            this.count = count;
        }    
    }
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;
    static int n,m;
    static int[][] map;
    static Queue<Info> q;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = maps[i][j];
            }
        }
        
        bfs(0,0,1);
        
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
    
    static void bfs(int x, int y, int cnt) {

        q = new LinkedList<>();
        q.add(new Info(x,y,cnt));

        while(!q.isEmpty()) {
            
            Info info = q.poll();
            
            if(info.x == n-1 && info.y == m-1) {
                answer = Math.min(answer, info.count);
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nx = info.x + dx[i];
                int ny = info.y + dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]==1) {
                    map[nx][ny] = 0;
                    q.add(new Info(nx,ny,info.count+1));
                }
            }
        }
        
    }
}