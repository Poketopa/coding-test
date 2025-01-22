import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<my_string.length();i++){
            if('0'<=my_string.charAt(i) && my_string.charAt(i)<='9'){
                list.add(Integer.valueOf(my_string.charAt(i) - 48));
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);

        return answer;
    }
}