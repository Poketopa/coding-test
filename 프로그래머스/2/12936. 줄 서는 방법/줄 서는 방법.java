import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long temp = 1;
        List<Long> factorial = new ArrayList<>();
        factorial.add((long)1);
        for(int i=1;i<=n;i++){
            temp *= i;
            factorial.add(temp);
        }
        List<Integer> number = new ArrayList<>();
        for(int i=1;i<=n;i++) number.add(i);
        int[] answer = new int[n];

        long count = (long)n;
        k--;
        for(int i=0;i<n;i++){
            answer[i] = ((int)(number.get((int) (k / factorial.get(factorial.size()-2-i)))));
            number.remove(number.get((int) (k / factorial.get(factorial.size()-2-i))));
            k %= factorial.get(factorial.size()-2-i);
        }
        return answer;
    }
}