class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max;
        int min;
        if(n>m){
            max = n;
            min = m;
        }
        else{
            max = m;
            min = n;
        }
        for(int i=max-1;i>0;i--){
            if(max%i==0&&min%i==0){
                answer[0]=i;
                break;
            }
        }
        for(int i=max;;i++){
            if(i%max==0&&i%min==0){
                answer[1]=i;
                break;
            }
        }
        return answer;
    }
}