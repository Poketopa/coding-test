import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 흠..
        // 0 2 1 2 1
        int[] student = new int[n];
        // lost -> 1
        for(int i : lost){
            student[i-1] = 1;
        }
        for(int i=0;i<reserve.length;i++){
            // 여벌이 도난당했을 경우
            if(student[reserve[i]-1] == 1){
                student[reserve[i]-1] = 0;
                reserve[i] = -1;
            }
        }
        for(int i : reserve){
            if(i==-1) continue;
            //맨 왼쪽 확인
            if(i == 1){
                if(student[1]==1){
                    student[1] = 0;
                    continue;
                }
            }
            else if(i==n){
                if(student[n-2]==1){
                    student[n-2] = 0;
                    continue;
                }
            }
            else{
                if(student[i-2]==1){
                    student[i-2] = 0;
                    continue;
                }
                else if(student[i] == 1){
                    student[i] = 0;
                    continue;
                }
            }
        }
        int answer = 0;
        for(int i : student){
            if(i==0) answer++;
        }
        return answer;
    }
}