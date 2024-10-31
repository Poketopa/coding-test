import java.util.*;
class Solution {
    public boolean solution(String s) {
        if(s.length()==4||s.length()==6){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)>='A'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}