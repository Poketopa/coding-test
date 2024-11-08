class Solution {
    public int solution(int n) {
        int num=0;
        for(int i=1;i<=n;i++){
            num++;
            while(num%3==0 || String.valueOf(num).contains("3")){
                num++;
            }
        }
        return num;
    }
}