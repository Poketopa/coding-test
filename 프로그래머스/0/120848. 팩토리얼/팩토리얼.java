class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==0){
            return 0;
        }
        // 먼저멀해볼가요
        // 1부터 11까지 팩토리얼
        int sum=1;
        
        for(int j=1;j<=11;j++){
            for(int i=1;i<=j;i++){
            sum*=i;
            }
            if(sum>n){
                return j-1;
            }
            sum=1;
        }
        
        
        
        return answer;
    }
}