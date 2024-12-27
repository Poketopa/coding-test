import java.util.*;

class Solution {
    public int solution(int n) {
        int x = 1;
        int y = 2;
        if(n == x) return x;
        if(n==y) return y;
        int next = 0;
        for(int i=3;i<=n;i++){
            next = x+y;
            if(next>=1000000007) next%=1000000007;
            x = y;
            y = next;
        }
        return next;
    }
}