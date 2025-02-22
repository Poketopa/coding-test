
import java.util.*;
class Solution {
    static int max = -1;
    public int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        int count = 1;
        for(int i=0;i<dungeons.length;i++){
            dfs(visited, count, k, dungeons, i);
        }
        return max;
    }

    private void dfs(int[] visited, int count, int k, int[][] dungeons, int now){
        if(visited[now] == 1) return;
        if(k<dungeons[now][0]) return;
        max = Math.max(max, count);
        visited[now] = 1;

        for(int i=0;i<dungeons.length;i++){
            dfs(visited, count + 1, k - dungeons[now][1], dungeons, i);
        }
        visited[now] = 0;
    }
}