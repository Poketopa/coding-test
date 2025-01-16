import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 1. 리스트 만들고 맨 처음 k개를 넣는다
        // 2. 내림차순 정렬
        // 3. 만약 마지막 인덱스보다 값이 크면 리스트에 넣고 올바른 자리까지 이동한다
        // 4. 리스트 마지막 remove
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<enemy.length;i++){
            if(queue.size()<k){
                queue.add(enemy[i]);
                continue;
            }
            if(enemy[i] > queue.peek()){
                n -= queue.peek();
                if(n<0) return i;
                queue.poll();
                queue.add(enemy[i]);
                continue;
            }
            n-=enemy[i];
            if(n<0) return i;
        }
        return enemy.length;
    }
}