import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String temp = String.valueOf(storey);

        int numLength = temp.length() - 1;
        while (true) {
            if(storey == 0) break;
            // 최고차수
            int max = storey / (int)Math.pow(10, numLength);
            // 최고차수 삭제
            int num = storey % (int)Math.pow(10, numLength);
            // 비교 숫자
            int five = 0;
            for(int i=0;i<=numLength;i++){
                five += 5 * (int)Math.pow(10, i);
            }
            if(numLength == 0){
                while(true){
                    // 양수이고
                    if(storey >= 0) {
                        // 5보다 크면 -10
                        if (storey > 5) {
                            storey -= 10;
                            answer++;
                        }
                        // 5보다 작으면
                        else {
                            answer += storey;
                            return answer;
                        }
                    }
                    // 음수이고
                    else{
                        // -5보다 작으면 +10
                        if(storey<-5){
                            storey+= 10;
                            answer++;
                        }
                        // -5보다 크면
                        else{
                            answer -= storey;
                            return answer;
                        }
                    }
                }

            }
            // 양수일 때
            if(storey>=0){
                // 첫글자가 5보다 크면
                if(storey >= five){
                    storey -= (int)Math.pow(10, numLength+1);
                    answer++;
                    numLength++;
                }
                else{
                    storey -= (max) * (int)Math.pow(10, numLength);
                    answer += max;
                }
            }
            else{
                if(storey<=-five){
                    storey += (int)Math.pow(10, numLength+1);
                    answer ++;
                    numLength++;
                }
                else{
                    storey -= (max) * (int)Math.pow(10, numLength);
                    answer -= max;
                }
            }
            numLength--;
        }
        return answer;
    }
}