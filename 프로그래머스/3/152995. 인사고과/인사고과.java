import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int luke1 = scores[0][0];
        int luke2 = scores[0][1];
        for(int i=1;i<scores.length;i++){ // 나락 감지
            if(scores[i][0] > luke1 && scores[i][1] > luke2){
                return -1;
            }
        }
        
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<int[]> validScores = new ArrayList<>();
        int maxPeerScore = 0;
        
        for (int[] score : scores) {
            if (score[1] >= maxPeerScore) {
                validScores.add(score); 
                maxPeerScore = Math.max(maxPeerScore, score[1]);
            }
        }
        
        
        validScores.sort((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        
    
        int score = 0;
        int max = Integer.MAX_VALUE;
        int temp = 1;
        
        for(int i=0;i<validScores.size();i++){
            int[] current = validScores.get(i);
            int sum = current[0] + current[1];
            
            if(max > sum) {
                score += temp;
                temp = 1;
                max = sum;
            } else {
                temp++;
            }
            

            if(current[0] == luke1 && current[1] == luke2){
                return score;
            }
        }
        return -1;
    }
}