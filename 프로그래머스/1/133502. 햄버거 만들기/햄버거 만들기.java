import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        // 1 -> 빵
        // 2 -> 야채
        // 3 -> 고개
        // 빵/야채/고기/빵 (1/2/3/1) 순서여야함
        int answer = 0;
        int index = 0;
        int burger = 0;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int notOne = 0;
        int prevIndex = 0;
        int number = 0;
        while(true){
            if(ingredient.length<4) break;
            // 버거가 없으면 (끝까지 탐색했으면 종료)
            if(index == ingredient.length){
                break;
            }
            if(ingredient[index] == -1){
                index++;
                continue;
            }
            // 1이면 버거 1
            if(ingredient[index] == 1){
                // 버거 완성이면
                if(burger == 3){
                    answer++;
                    number++;
                    index4 = index;
                    burger = 0;
                    ingredient[index1] = -1;
                    ingredient[index2] = -1;
                    ingredient[index3] = -1;
                    ingredient[index4] = -1;
                    prevIndex = index;
                    while(ingredient[index]!=1){
                        if(index==0){
                            notOne = prevIndex;
                            index = notOne;
                            break;
                        }
                        if(index==notOne){
                            notOne=prevIndex;
                            index=notOne;
                            break;
                        }
                        index--;
                    }
                    continue;
                }
                // 완성이 아니면
                else{
                   burger = 1;
                   index1 = index;
                }
            }
            // 2이고 버거가 1이면 2
            else if(ingredient[index] == 2){
                if(burger == 1){
                    burger = 2;
                    index2 = index;
                }
                else{
                    burger = 0;
                }
            }
            // 3이고 버거가 2이면 3
            else if(ingredient[index] == 3){
                if (burger == 2) {
                    burger = 3;
                    index3 = index;
                }
                else{
                    burger = 0;
                }
            }
            index++;
        }
        return answer;
    }
}