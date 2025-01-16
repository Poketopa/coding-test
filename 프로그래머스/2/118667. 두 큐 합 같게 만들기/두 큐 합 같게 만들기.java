import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> newQueue1 = new LinkedList<>();
        Queue<Integer> newQueue2 = new LinkedList<>();
        int length = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        for(int i : queue1) {
            newQueue1.add(i);
            sum1+=i;
        }
        for(int i : queue2) {
            newQueue2.add(i);
            sum2+=i;
        }

        int count = 0;
        while(sum1 != sum2){
            // 1이 더 크면 1에서 빼서 2에 넣음
            if(sum1>sum2){
                int temp = newQueue1.poll();
                newQueue2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            }
            else{
                int temp = newQueue2.poll();
                newQueue1.add(temp);
                sum1 += temp;
                sum2 -= temp;
            }
            count++;
            if(count > 3 * length) return -1;
        }
        return count;
    }
}