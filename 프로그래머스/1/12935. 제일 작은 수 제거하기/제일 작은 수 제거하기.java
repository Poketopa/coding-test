import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        
        List<Integer> newList = new ArrayList<>();
        for (int i : arr){
            if (i == min){
                continue;
            }
            newList.add(i);
        }
        int[] answer = newList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}