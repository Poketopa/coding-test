class Solution {
    public long[] solution(int x, int n) {
        long number = x;
        long[] answer = new long[n];
        if (x == 0){
            return answer;
        }
        for (int i=0;i<n;i++){
            answer[i] = number;
            number+=x;
        }
        
        return answer;
    }
}