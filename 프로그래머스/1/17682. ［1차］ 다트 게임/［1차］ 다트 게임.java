import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] result = new int[3];
        int index = -1;
        String[] dart = dartResult.split("");
        for(int i=0;i<dart.length;i++){
            if(dart[i].equals("e")) continue;
            else if(dart[i].equals("S")){
                continue;
            }
            else if(dart[i].equals("D")){
                result[index] = (int)Math.pow(result[index],2);
                continue;
            }
            else if(dart[i].equals("T")){
                result[index] = (int)Math.pow(result[index],3);
                continue;
            }
            else if(dart[i].equals("*")){
                if(index == 0){
                    result[index] *= 2;
                }
                else{
                    result[index] *=2;
                    result[index-1] *= 2;
                }
            }
            else if(dart[i].equals("#")) {
                result[index] *= -1;
            }
            else{
                index++;
                if(dart[i].equals("1")&&dart[i+1].equals("0")){
                    result[index] = 10;
                    dart[i+1] = "e";
                }
                else{
                    result[index] = Integer.valueOf(dart[i]);
                }
                continue;
            }
        }
        int answer = 0;
        for(int i : result){
            answer+=i;
        }
        return answer;
    }
}