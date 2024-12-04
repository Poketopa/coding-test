import java.util.*;

// 2차원 배열에 넣기
// 확인하면서 한번 봤으면 visited만들어서 1 넣기
class Solution {
    static int answer = 0;

    public int solution(int n, int[][] computers) {
        int[] visited = new int[computers.length];


        // 흠...
        // 1. i 로 0, 1, 2 들어간다
        // 2. i가 1일 때 : dfs i가 2이면 dfs(1) 들어감
        //               2에서 1일 때 dfs(1)들어감 (들어가면 안됨 visited == 0)
        //               2에서 3일 때 dfs(3)들어감
        for(int i=0;i<computers.length;i++){
            if(visited[i]==0){
                answer++;
            }
            dfs(computers, i, visited);

        }
        return answer;

    }

    private static void dfs(int[][] computers, int index, int[] visited){
        // 이미 연결됐던 네트워크면 돌아감
        if(visited[index] == 1){
            return;
        }
        // 아니면 끝가지 파고듦
        for(int i=0;i<computers.length;i++){

            if(computers[index][i]==1&&visited[i]==0){
                visited[index] = 1;
                dfs(computers, i, visited);
            }
        }
    }
}