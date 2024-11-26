import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            int sum = 0;
            for(int j=1;j*j<=i;j++){
                if(i%j==0){
                    sum++;
                    if(j != i/j){
                        sum++;
                    }
                    if(sum>limit){
                        sum=power;
                        break;
                    }
                }
            }
            answer+=sum;
        }
        return answer;
    }
}