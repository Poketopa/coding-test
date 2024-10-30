import java.util.*;

class Solution {
    public String solution(String s) {
    	String[] str = s.split("");
        List<String> list = new ArrayList<>();
        list = Arrays.asList(str);
        Collections.sort(list,Collections.reverseOrder());
        String answer = String.join("", list);
        return answer;
    }
}