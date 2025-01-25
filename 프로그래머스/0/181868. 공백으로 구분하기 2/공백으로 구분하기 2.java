import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] temp = my_string.split(" ");
        List<String> list = new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            if(temp[i].length() == 0 )continue;
            list.add(temp[i]);
        }
        
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}