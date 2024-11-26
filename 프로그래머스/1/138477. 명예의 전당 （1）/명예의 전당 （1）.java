import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] honor = new int[k];
        Arrays.fill(honor, -1);
        for(int i=0;i<score.length;i++){
            if(honor[0]<score[i]){
                honor[0] = score[i];
            }
            Arrays.sort(honor);
            for(int j=0;j<honor.length;j++){
                if(honor[j]==-1){
                    continue;
                }
                else{
                    answer[i] = honor[j];
                    break;
                }
            }
        }
        return answer;
    }
}