class Solution {
    public int[] solution(int n, int s) {
        // 1. s를 2로 나눈다 (나머지 저장)
        if(n>s){
            return new int[]{-1};
        }
        int remain = s%n;
        int num = s/n;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = num;
        }
        for(int i = 0;i<remain;i++){
            answer[answer.length-1-i]+=1;
        }
        return answer;
    }
}