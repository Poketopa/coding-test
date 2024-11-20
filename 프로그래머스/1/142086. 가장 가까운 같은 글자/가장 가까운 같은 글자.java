import java.util.*;

class Solution {
    public int[] solution(String s) {
        String compare="";
        int[] answer = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(compare.contains(String.valueOf(s.charAt(i)))){
                int num = 0;
                int j=i-1;
                while(s.charAt(i)!=s.charAt(j)){
                    j--;
                }
                answer[i]=i-j;
            }
            else{
                compare+=s.charAt(i);
                answer[i]=-1;
            }
        }
        return answer;
    }
}