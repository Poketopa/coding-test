import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int[] serverDown = new int[100];
        int count = 0;
        // 몇이 넘으면 증설해야한다
        int max = m;
        for(int i=0;i<players.length;i++){
            max -= serverDown[i] * m;
            while(players[i] >= max){
                count++;
                max += m;
                serverDown[i + k]++;
            }
        }
        return count;
    }
}