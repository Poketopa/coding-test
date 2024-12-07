import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        for(int i=0;i<n;i++){
            if(works[works.length-1]==0){
                continue;
            }
            works[works.length-1]--;
            // sort 방식 말고 인덱스, 마지막 인덱스 정수 변수 만들어서
            // while문으로 작거나 같은거 나올 때까지 스왑
            int index = works.length-1;
            while(true){
                if(index > 0 && works[index]<works[index-1]){
                    int temp = works[index];
                    works[index] = works[index-1];
                    works[index-1] = temp;
                    index--;
                }
                else{
                    break;
                }
            }
        }
        long answer = 0;
        for(long i : works){
            answer += i*i;
        }
        return answer;
    }
}