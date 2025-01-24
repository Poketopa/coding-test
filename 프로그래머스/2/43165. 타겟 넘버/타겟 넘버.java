import java.util.*;
import java.math.*;

class Solution {
    static int answer = 0;
    static int sum = 0;
    public int solution(int[] numbers, int target) {
        // 합 만들기
        for(int i : numbers) sum += i;
        int[] visited = new int[numbers.length];

        for(int i=0;i<numbers.length;i++){
            dfs(numbers, target, visited, i);
        }
        return answer;
    }

    private void dfs(int[] numbers, int target, int[] visited, int nowIndex){
        // 1. visited 확인, 갱신
        if(visited[nowIndex] == 1) return;
        visited[nowIndex] = 1;
        sum -= numbers[nowIndex] *  2;

        // 2. 조건 확인
        if(sum <= target){
            if(sum == target){
                answer++;
            }
        }
        else{
            // 3. 재귀
            for(int i= nowIndex+1;i<numbers.length;i++){
                dfs(numbers, target, visited, i);
            }
        }

        sum += numbers[nowIndex] * 2;
        visited[nowIndex] = 0;
    }
}