class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0;
        int zeroCount = 0;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    correct++;
                    win_nums[j]=-1;
                }
            }
            if(lottos[i] == 0) zeroCount++;
        }
        int best = 7-correct - zeroCount;
        if(best>6) best = 6;
        int worst = 7-correct;
        if(worst>6) worst = 6;
        return new int[]{best,worst};
    }
}