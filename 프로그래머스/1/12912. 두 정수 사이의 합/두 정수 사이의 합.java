class Solution {
    public long solution(int a, int b) {
        int min;
        int max;
        long answer = 0;
        if(a>b){
            max = a;
            min = b;
        }
        else{
            max = b;
            min = a;
        }
        for (;min<=max;min++){
            answer+= min;   
        }
        return answer;
    }
}