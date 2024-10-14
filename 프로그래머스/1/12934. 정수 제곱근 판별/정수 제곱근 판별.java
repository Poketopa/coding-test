class Solution {
    public long solution(long n) {
        long num = 1;
        while(true){
            if (num * num == n){
                return (num+1) * (num+1);
            }
            else if(num * num > n){
                return -1;
            }
            num++;
        }
    }
}