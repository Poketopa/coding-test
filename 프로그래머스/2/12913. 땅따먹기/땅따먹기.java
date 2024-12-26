import java.util.*;

class Solution {
    int solution(int[][] land) {
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                findMax(i, j, land);
            }
        }
        int max = -1;
        for(int i=0;i<4;i++){
            if(land[land.length-1][i]>max){
                max = land[land.length-1][i];
            }
        }
        return max;
    }

    private static void findMax(int i, int j, int[][] land){
        int max = -1;
        for(int k=0;k<4;k++){
            if(k==j) continue;
            if(land[i-1][k]>max) {
                max = land[i-1][k];
            }
        }
        land[i][j] += max;
    }
}