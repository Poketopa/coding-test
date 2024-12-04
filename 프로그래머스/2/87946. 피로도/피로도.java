import java.util.*;

class Solution {
    static int max = -1;

    public int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        dfs(k, dungeons, 0, visited);
        return max;
    }

    private static void dfs(int hp, int[][] dungeons, int count, int[] visited){
        max = Math.max(max, count);

        for(int i=0;i<visited.length;i++){
            // 이미 왔을 때
            if(visited[i]==1) {
                continue;
            }
            // 체력 없어서 못 들어갈 때
            if(hp<dungeons[i][0]){
                continue;
            }
            visited[i] = 1;
            dfs(hp-dungeons[i][1], dungeons, count+1, visited);
            visited[i] = 0;
        }
    }
}