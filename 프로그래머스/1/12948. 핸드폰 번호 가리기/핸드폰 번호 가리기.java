import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String[] array = phone_number.split("");
        for(int i=0;i<array.length-4;i++){
            array[i] = "*";
        }
        String answer = "";
        for (String i:array){
            answer+=i;
        }

        return answer;
    }
}