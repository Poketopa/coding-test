import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int size = k;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(true){
           int num = number.charAt(index)-48;
           if(stack.isEmpty()){
               stack.push(num);
           }
           else if(k==0){
               stack.push(num);
               if(stack.size()==number.length()-k){
                   break;
               }
           }
           else{
               while(!stack.isEmpty()&&stack.get(stack.size()-1)<num){
                   if(k==0)break;
                   stack.pop();
                   k--;
               }
               stack.push(num);
           }
           index++;
           // 끝에 도착했으면
           if(index == number.length()){
               for(int i=0;i<k;i++){
                   stack.pop();
               }
               break;
           }
        }
        String answer = "";
        for(int i=0;i<stack.size();i++){
            answer += String.valueOf(stack.get(i));
        }
        return answer;
    }
}