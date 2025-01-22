import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        BigInteger bigNum1 = new BigInteger("1");
        BigInteger bigNum2 = new BigInteger("1");
        BigInteger bigNum3 = new BigInteger("1");
        for(int i=1;i<=balls;i++){
            bigNum1 = bigNum1.multiply(BigInteger.valueOf(i));
        }
        for(int i=1;i<=balls - share;i++){
            bigNum2 = bigNum2.multiply(BigInteger.valueOf(i));
        }
        for(int i=1;i<=share;i++){
            bigNum3 = bigNum3.multiply(BigInteger.valueOf(i));
        }

        BigInteger result = bigNum1.divide(bigNum2.multiply(bigNum3));
        int answer = Integer.valueOf(String.valueOf(result));
        return answer;
    }
}