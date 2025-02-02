import java.util.*;
import java.math.*;

class Solution {
    public long solution(int k, int d) {
        // x^2 + y^2 = d^2
        // y^2 = d - x^2
        // y = sqrt(d^2 - x^2)
        long k2 = (long)k * (long)k;
        long d2 = (long)d * (long)d;
        // x^2 + y^2 = d^2
        long answer = 0;
        for(long i=0;i<=d;i+=k){
            // i^2 + y^2 <= d^2
            long y = (long)Math.sqrt((Math.pow(d, 2) - Math.pow(i, 2)));
            answer += (y / k) + 1;
        }
        return answer;
    }
}