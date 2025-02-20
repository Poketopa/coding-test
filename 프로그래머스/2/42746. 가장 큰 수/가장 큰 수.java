import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) num[i] = String.valueOf(numbers[i]);
        Arrays.sort(num, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        String answer = "";
        for(String i : num) answer += i;
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}