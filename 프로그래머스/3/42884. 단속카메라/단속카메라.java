import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b)->{
            return a[1]-b[1];
        });
        for(int i=0;i<routes.length;i++){
            // 이미 cctv 설치된 곳이면 넘어감
            if(routes[i][0]==99999) continue;
            // 출차 지점에서 확인
            int camera = routes[i][1];
            answer++;
            // 카메라 설치하고 모든 곳 확인하면서 겹치면 99999
            for(int[] j : routes){
                if(j[0]==99999) continue;
                if(j[0]<=camera&&camera<=j[1]) j[0]=99999;
            }
        }
        return answer;
    }
}