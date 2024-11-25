import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int sum = numbers[i]+numbers[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        int prev = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)==prev){
                list.remove(i);
                i--;
            }
            else{
                prev = list.get(i);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}