package com.sulim.study_0909;

import java.util.*;

class Solution {
    
    static boolean visited[];
    static ArrayList<Integer>[] list;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if((i != j) && computers[i][j]==1) {
                    list[i].add(j);
                } 
            }
        }
       
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    
    static void dfs(int cur) {
        
            visited[cur] = true;
        
            for(int i=0; i<list[cur].size(); i++) {
                int next = list[cur].get(i);
                if(!visited[next]) {
                    dfs(next);
                }
            }
    }
}