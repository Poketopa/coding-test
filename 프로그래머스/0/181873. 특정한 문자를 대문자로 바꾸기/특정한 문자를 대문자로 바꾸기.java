import java.util.*;
class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for(int i=0;i<my_string.length();i++){
            if(String.valueOf(my_string.charAt(i)).equals(alp)){
                answer += String.valueOf(Character.toUpperCase(my_string.charAt(i)));
            }
            else answer += String.valueOf(my_string.charAt(i));
        }
        return answer;
    }
}