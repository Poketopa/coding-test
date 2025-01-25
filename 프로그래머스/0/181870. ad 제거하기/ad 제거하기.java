import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<strArr.length;i++){
            int temp = strArr[i].length();
            if(strArr[i].replace("ad", "").length() == temp) list.add(strArr[i]);
        }
    
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++) answer[i] = list.get(i);
        return answer;
    }
}