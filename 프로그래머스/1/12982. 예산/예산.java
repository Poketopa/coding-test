import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for(int i : d){
            budget-=i;
            if(budget<0){
                return answer;
            }
            answer++;
        }
        return answer;
    }
}