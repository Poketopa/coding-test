import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int length = deliveries.length-1;
        int delBox = 0;
        int picBox = 0;
        // 끝부터 탐색한다
        for(int i = n-1;i>=0;i--){
            delBox -= deliveries[i];
            picBox -= pickups[i];
            int count = 0;

            while(delBox < 0 || picBox < 0){
                delBox+=cap;
                picBox+=cap;
                count++;
            }
            answer += (long) count * 2 * (i+1);
        }
        return answer;
    }
}