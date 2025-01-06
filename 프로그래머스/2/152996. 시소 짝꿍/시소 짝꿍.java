import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 몸무게 - 몸무게를 가진 사람 수 매핑
        HashMap<Long, Long> map = new HashMap<>();
        for(long i:weights){
            map.put(i, map.getOrDefault(i, Long.valueOf(0))+1);
        }
        Set<Long> set = map.keySet();
        // 배열에 해시맵 요소 저장
        Long[] mapArray = set.toArray(new Long[0]);
        for(int i=0;i<mapArray.length;i++){
            // 몸무게가 같은 경우 nC2 연산
            if(map.get(mapArray[i])>1){
                answer += map.get(mapArray[i]) * (map.get(mapArray[i])-1) / 2;
            }
            for(int j=i+1;j<mapArray.length;j++){
                // 몸무게 비율이 2:4 인 경우
                if(Objects.equals(4*mapArray[i],2*mapArray[j])||Objects.equals(2*mapArray[i] ,4*mapArray[j])) {
                    answer += (long)map.get(mapArray[i]) * map.get(mapArray[j]);
                    continue;
                }
                // 몸무게 비율이 3:2 인 경우
                if(Objects.equals(3*mapArray[i],2*mapArray[j])||Objects.equals(2*mapArray[i] ,3*mapArray[j])) {
                    answer += (long)map.get(mapArray[i]) * map.get(mapArray[j]);
                    continue;
                }
                // 몸무게 비율이 4:3 인 경우
                if(Objects.equals(4*mapArray[i],3*mapArray[j])||Objects.equals(3*mapArray[i] ,4*mapArray[j])) {
                    answer += (long)map.get(mapArray[i]) * map.get(mapArray[j]);
                }
            }
        }
        return answer;
    }
}