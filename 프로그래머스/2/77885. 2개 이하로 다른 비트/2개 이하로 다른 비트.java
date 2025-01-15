import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];


        x:
        for(int i=0;i<numbers.length;i++){
            String number = Long.toBinaryString(numbers[i]);
            String[] temp = number.split("");
            for(int j=temp.length-1;j>=0;j--){
                if(temp[j].equals("0")){
                    temp[j] = "1";
                    if(j+1 != temp.length){
                        temp[j+1] = "0";
                    }
                    String result = String.join("", temp);
                    answer[i] = Long.valueOf(result, 2);
                    continue x;
                }
            }
            // 모든 수가 1인경우
            temp[0] = "0";
            String temp1 = String.join("", temp);
            temp1 = "1" + temp1;
            answer[i] = Long.valueOf(temp1, 2);
        }

        return answer;
    }
}