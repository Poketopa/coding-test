import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        // 스택에 인텍스 넣는다
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            // 처음이거나 / 스택의 맨 위가 다음 값보다 클 때
            if(stack.isEmpty() || numbers[stack.peek()]>= numbers[i]){
                // 스택에 넣는다
                stack.add(i);
            }
            else{
                // 다음 값보다 큰 값이 나올 떄까지 꺼냄 스택 사용할 떈 항상 empty 체크
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                    int index = stack.pop();
                    answer[index] = numbers[i];
                }
                stack.add(i);
            }
        }
        for(int j=0;j<answer.length;j++){
                if(answer[j] == 0) answer[j] = -1;
            }
        return answer;
    }
}