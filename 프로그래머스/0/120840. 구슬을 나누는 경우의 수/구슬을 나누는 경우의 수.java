import java.math.*;
class Solution {
    public int solution(int balls, int share) {
        BigInteger mom = new BigInteger("1");
        BigInteger son = new BigInteger("1");
        for(int i=share+1;i<=balls;i++){
            mom = mom.multiply(BigInteger.valueOf(i));
        }
        for(int i=1;i<=balls-share;i++){
            son = son.multiply(BigInteger.valueOf(i));
        }
        int answer = mom.divide(son).intValue();
        return answer;
        
        
    }
}