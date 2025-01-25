class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num-end_num+1];
        int temp = start_num;
        for(int i=0;i<answer.length;i++){
            answer[i] = temp--;
        }
        return answer;
    }
}