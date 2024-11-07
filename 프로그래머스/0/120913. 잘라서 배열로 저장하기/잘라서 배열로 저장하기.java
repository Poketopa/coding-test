import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] str = my_str.split("");
        String answer = "";
        String[] result = new String[((str.length-1)/n)+1];
        int count = 0;
        for(int i=0;i<str.length;i++){
            answer+=str[i];
            if((i%n == n-1) || i == str.length-1){
                result[count] = answer;
                answer = "";
                count++;
            }

        }
        return result;
    }
}