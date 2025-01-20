import java.util.*;

class Solution {
    static int sum = 0;
    static int answer = 0;
    public int solution(int N, int[][] road, int K) {
        int[] how = new int[N+1];
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<road.length;i++){
            list.get(road[i][0]).add(new int[]{road[i][1], road[i][2]});
            list.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
        }
        int[]visited = new int[N+1];

        int start = 1;

        dfs(list, visited, start, 0, K, how);
        for(int i : how) if(i == 1) answer++;
        return answer;
    }

    private void dfs(List<List<int[]>> list, int[] visited, int start, int cost, int max, int[] how){
        // 1. 들어온 곳 visited 확인하고 visited 업데이트
        if(visited[start] == 1) return;
        if(sum + cost > max) return;
        visited[start] = 1;
        sum += cost;
        how[start] = 1;

        for(int i=0;i<list.get(start).size();i++){
            dfs(list, visited, list.get(start).get(i)[0], list.get(start).get(i)[1], max , how);

        }
        visited[start] = 0;
        sum-=cost;
    }
}