import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] fight = new int[n+1][n+1];
        for(int i=0;i<results.length;i++){
            fight[results[i][0]][results[i][1]] = 1;
            fight[results[i][1]][results[i][0]] = -1;
        }
        // 만약 A가 B를 이겼다면? -> A를 이긴사람은 모두 B를 이긴다
        // fight[1][2] == 1 이면 fight[n][1] == 1인 사람은 모두 fight[n][2] = 1

        // 만약 A가 B에게 졌다면? -> A에게 진사람은 모두 B에게 진다
        // fight[1][2] == -1 이면 fight[n][1] == -1인 사람은 모두 fight[n][2] = -1
        for(int i=1;i<fight.length;i++){
            for(int j=1;j<fight.length;j++){
                // 자기 자신이면 continue
                if(i==j) continue;
                // i가 j를 이기면
                if(fight[i][j] == 1){
                    for(int k=1;k<fight.length;k++){
                        if(fight[k][i] == 1) fight[k][j] = 1;
                    }
                }
                else if(fight[i][j] == -1){
                    for(int k=1;k<fight.length;k++){
                        if(fight[k][i] == -1) fight[k][j] = -1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=1;i<fight.length;i++){
            int temp = 0;
            for(int j=1;j<fight.length;j++){
                if(fight[i][j] != 0) temp++;
            }
            if(temp == n-1) answer++;
        }
        return answer;
    }
}