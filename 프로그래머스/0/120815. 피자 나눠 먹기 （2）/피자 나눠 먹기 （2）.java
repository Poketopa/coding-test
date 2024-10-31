class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = n;
        while(true){
            if(a%6==0){
                return a/6;
            }
            else{
                a+=n;
            }
        }
        
        
    }
}