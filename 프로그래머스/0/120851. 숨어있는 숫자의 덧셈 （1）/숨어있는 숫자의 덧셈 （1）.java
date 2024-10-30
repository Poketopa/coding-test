import java.util.*;

class Solution {
    public int solution(String my_string) {
    	int answer = 0;
    	String[] str = my_string.split("");
    	for(int i=0;i<str.length;i++) {
    		if((int)str[i].charAt(0)>48 && (int)str[i].charAt(0)<=57) {
    			answer+= (int)str[i].charAt(0) - 48;
    		}
    	}
        return answer;
    }
}