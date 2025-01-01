import java.util.*;

class Solution {
    public int solution(String s) {
        int countX = 1;
        int countY = 0;
        char X = s.charAt(0);
        int answer = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==X) countX++;
            else countY++;
            if(countX==countY){
                if(i==s.length()-1){
                    continue;
                }
                else{
                    answer++;
                    X = s.charAt(i+1);
                    countX = 0;
                    countY = 0;
                }
            }
        }
        return answer;
    }
}