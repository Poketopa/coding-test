import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1부터 n까지 돌면서 확인한다
        // 각각 double(실패율) 값을 저장하는 배열 존재
        // [0, 0, 0, 4]
        // [1, 2, 3, 4] 인덱스 매핑?

        // [0, 0.5, 0.3, 0, 0.2]
        // 2, 3, 5, 1, 4 reverse 정렬 (인덱스를 정렬하고 람다식으로 기준을 stages로 잡음)

        // 실패율 배열
        float[] fail = new float[N];
        // 인덱스 배열
        Integer[] index = new Integer[N];

        int people = stages.length;

        for(int i=1;i<=N;i++){
            index[i-1] = i;
            int howFail = 0;
            for(int j=0;j<stages.length;j++){
                if(stages[j]==-1){
                    continue;
                }
                if(stages[j]<=i){
                    stages[j]=-1;
                    howFail = howFail+1;
                }
            }
            fail[i-1] = (howFail==0)? 0 : (float)howFail/people;
            people-=howFail;
        }
        Arrays.sort(index,(a,b)->{
            if(fail[a-1]>fail[b-1]){
                return -1;
            }
            else if(fail[a-1]<fail[b-1]){
                return 1;
            }
            else{
                return a-b;
            }
        });
        int[] answer = new int[N];
        for(int i=0;i<N;i++){
            answer[i] = index[i];
        }
        return answer;
    }
}