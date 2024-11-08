import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int[] arr = new int[3];
        int answer = 0;
        for(int i=1;i<sides[0]+sides[1];i++){
            arr[0] = sides[0];
            arr[1] = sides[1];
            arr[2] = i;
            Arrays.sort(arr);
            if((arr[0]+arr[1])>arr[2]){
                answer++;
            }
        }
        return answer;
    }
}