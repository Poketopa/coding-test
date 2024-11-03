import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] str = my_string.toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i]>='A'&&str[i]<='Z'){
                str[i]+=32;
            }
        }
        Arrays.sort(str);
        String answer = "";
        for(int i=0;i<str.length;i++){
            answer+=(str[i]);
        }
        return answer;
    }
}