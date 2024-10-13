class Solution {
    public int[] solution(long n) {
        // 자릿수 구하기
        int count = 0;
        long testN = n;
        while(testN>0){
            testN /= 10;
            count +=1;
        }
        int[] answer = new int[count];
        for (int i=0;i<count;i++){
            answer[i] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }
}