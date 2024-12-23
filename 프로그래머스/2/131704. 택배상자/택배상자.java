import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 다음 오더 확인
        // 현재 숫자보다 크면 그 숫자 될때까지 뺀다
        // 현재 숫자보다 작으면 컨테이너를 확인한다 없으면 리턴
        int answer = 0;
        Stack<Integer> container = new Stack<>();
        int[] list = new int[order.length];
        for(int i=0;i<order.length;i++){
            list[i]=i+1;
        }
        int nowIndex = 0;
        for(int i : order){
            // 오더가 현재 숫자보다 크거나 같으면
            if(nowIndex != list.length&&i>=list[nowIndex]){
                while(true){
                    if(i==list[nowIndex]){
                        nowIndex++;
                        answer++;
                        break;
                    }
                    else{
                        container.push(list[nowIndex]);
                        nowIndex++;
                    }
                }
            }
            // 컨테이너에서 찾아야한다면
            else{
                if(!container.isEmpty()){
                    if(container.get(container.size()-1)==i){
                        container.pop();
                        answer++;
                    }
                    else{
                        return answer;
                    }
                }
                else{
                    return answer;
                }
            }
        }
        return answer;
    }
}