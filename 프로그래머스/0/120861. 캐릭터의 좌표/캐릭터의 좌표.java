class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int left = -(board[0]/2);
        int right = -left;
        int up = (board[1]/2);
        int down = -up;
        
        for(int i=0;i<keyinput.length;i++){
            if(keyinput[i].equals("left")){
                if(answer[0]>left){
                    answer[0]--;
                }
            }
            else if(keyinput[i].equals("right")){
                if(answer[0]<right){
                    answer[0]++;
                }
            }
            else if(keyinput[i].equals("up")){
                if(answer[1]<up){
                    answer[1]++;
                }
            }
            else{ // down
                if(answer[1]>down){
                    answer[1]--;
                }
            }
        }
        return answer;
    }
}