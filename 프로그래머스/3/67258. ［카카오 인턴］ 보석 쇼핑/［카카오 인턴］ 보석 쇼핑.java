import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(String[] gems) {
        // 보석 개수 세기 (해시맵 이용)
        // 큐 만들어서 보석 종류를 다 모으면 현재 크기 업데이트 하기
        HashMap<String, Integer> map = new HashMap<>();
        for(String i : gems) {
            if(map.containsKey(i)) continue;
            else map.put(i, 0);
        }
        String[] gem = map.keySet().toArray(new String[0]);
        int gemType = map.size();

        // 1. 큐에 다음 요소를 넣는다 (if 배열이 끝났으면?)
        // if 배열이 끝났으면 -> 줄이면서 모든 요소를 확인하고 없어지는 순간 끝
        // 2. gem 배열을 돌면서 모든 요소가 있는지 확인한다
        // 없다면 -> 다시 큐에 요소를 넣는다.
        // 있다면 -> 계속 줄이면서 확인한다 (없을 때까지)
        Queue<String> queue = new LinkedList<>();
        int nowType = 0;
        int startIndex = 0;
        int endIndex = 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        boolean flag = false;
        x :
        while(true){
            // 만약 벽이면
            if(startIndex != gems.length){
                // 큐, 맵에 넣기
                queue.add(gems[startIndex]);
                map.put(gems[startIndex], map.get(gems[startIndex]) + 1);
                startIndex++;
                if(startIndex == gems.length){
                    flag = true;
                }
            }
            // 해시맵 확인
            for(int i=0;i<gem.length;i++){
                if(map.get(gem[i]) == 0){
                    if(flag) break x;
                    continue x;
                }
            }
            // 가득 찼다면?
            while(true){
                if(min > queue.size()){
                    min = queue.size();
                    answer[0] = endIndex;
                    answer[1] = startIndex;
                }
                String temp = queue.poll();
                endIndex++;
                map.put(temp, map.get(temp)-1);
                if(map.get(temp) == 0) break;
            }
        }
        return answer;
    }
}