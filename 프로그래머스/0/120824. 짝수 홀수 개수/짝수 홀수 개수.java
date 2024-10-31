class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0,0};
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]%2 == 1){
                answer[1]++;
            }
            else{
                answer[0]++;
            }
        }
        return answer;
    }
}