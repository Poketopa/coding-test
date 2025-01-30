import java.util.*;
import java.math.*;
class Solution {
    public int solution(int a, int b) {
        String newA = String.valueOf(a);
        String newB = String.valueOf(b);
        if(Integer.valueOf(newA+newB)<Integer.valueOf(newB+newA)) return Integer.valueOf(newB+newA);
        else return Integer.valueOf(newA+newB);
    }
}