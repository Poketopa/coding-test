import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int count=0;
        // 1. 큐에 요소를 넣는다
        // 2. 팝한 요소에 대해서 연산을 3개 한다
        // 3. 큐에 3개를 넣는다
        queue.offer(new int[]{x, count});
        int[] number = new int[2];
        while(true){
            if(queue.isEmpty()){
                return -1;
            }
            number = queue.poll();
            if(number[0]>=y){
                if(number[0]==y){
                    return number[1];
                }
                else{
                    continue;
                }
            }
            if(!set.contains(number[0]+n)){
                queue.offer(new int[]{number[0]+n,number[1]+1});
                set.add(number[0]+n);
            }
            if(!set.contains(number[0]*2)){
                queue.offer(new int[]{number[0]*2,number[1]+1});
                set.add(number[0]*2);
            }
            if(!set.contains(number[0]*3)){
                queue.offer(new int[]{number[0]*3,number[1]+1});
                set.add(number[0]*3);
            }
        }
    }
}