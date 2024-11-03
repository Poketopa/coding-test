import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        int length = my_string.length();
        for(int i=0;i<length;i++){
            answer+=my_string.charAt(0);
            my_string = my_string.replace(Character.toString(my_string.charAt(0)),"");
            if(my_string.length() == 0){
                break;
            }
        }
        return answer;
    }
}