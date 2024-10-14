import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        int count =0;
        for (int i=0;i<arr.length;i++){
            if (arr[i] % divisor == 0){
                count++;
            }
        }
        if (count == 0){
            int[] answer1 = new int[1];
            answer1[0]= -1;
            return answer1;
        }
        int[] answer = new int[count];
        int answerCount = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]%divisor == 0){
                answer[answerCount]=arr[i];
                answerCount++;
            }
        }
        return answer;
    }
}