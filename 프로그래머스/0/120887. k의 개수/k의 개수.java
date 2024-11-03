import java.util.*;
class Solution {
    public int solution(int i, int j, int k) {
        String kNum = String.valueOf(k);
        String str = "";
        int answer = 0;
        for(;i<=j;i++){
            str = String.valueOf(i);
            String[] arr = str.split("");
            for(String number:arr){
                if(number.equals(kNum)){
                    answer++;
                }
            }
        }
        

        return answer;
    }
}