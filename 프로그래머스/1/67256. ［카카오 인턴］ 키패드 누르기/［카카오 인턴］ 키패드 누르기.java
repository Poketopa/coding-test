import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        for(int i=0;i<numbers.length;i++) if(numbers[i]==0) numbers[i] = 11;
        // 더 크면
        // 1. 3의 몇 배수인지 확인 -> +1
        // 2. 몇을 더해야 하는지 확인 -> +1
        // 더 작으면
        // 흠..
        int left = 10;
        int right = 12;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1||numbers[i] == 4||numbers[i] == 7){
                left = numbers[i];
                answer += "L";
            }
            else if(numbers[i] == 3||numbers[i] == 6||numbers[i] == 9){
                right = numbers[i];
                answer += "R";
            }
            else{
                int leftMin = min(numbers[i], left);
                int rightMin = min(numbers[i], right);
                if(leftMin < rightMin){
                    left = numbers[i];
                    answer += "L";
                }
                else if(leftMin > rightMin){
                    right = numbers[i];
                    answer += "R";
                }
                else{
                    if(hand.equals("right")){
                        right = numbers[i];
                        answer += "R";
                    }
                    else{
                        left = numbers[i];
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }

    private int min(int number, int finger){
        int count = 0;
        if(number>finger){
            while(true){
                if(number == finger) break;
                // 3이상 차이나면 내려감
                if(number>=finger + 3){
                    finger += 3;
                    count++;
                }
                else if(number + 2% 3 < finger + 2 % 3){
                    finger+=3;
                    count++;
                }
                else if(number<finger){
                    finger -=1;
                    count++;
                }
                else if(number>finger){
                    finger +=1;
                    count++;
                }
            }
        }
        else if(number<finger){
            while(true){
                if(number == finger) break;
                // 3이상 차이나면 내려감
                if(number+3<=finger){
                    finger -= 3;
                    count++;
                }
                else if(number + 2% 3 > finger + 2 % 3){
                    finger-=3;
                    count++;
                }
                else if(number<finger){
                    finger -=1;
                    count++;
                }
                else if(number>finger){
                    finger +=1;
                    count++;
                }
            }
        }
        else{
            return 0;
        }
        return count;
    }
}