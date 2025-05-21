import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int length = intervals[0][1] + intervals[1][1] - intervals[0][0] - intervals[1][0] + 2 ;
        int[] answer = new int[length];
        int index = 0;
        for(int i=intervals[0][0];i<=intervals[0][1];i++) {
            answer[index] = arr[i];
            index++;
        }
        for(int i=intervals[1][0];i<=intervals[1][1];i++){
            answer[index] = arr[i];
            index++;
        }
        return answer;
    }
}