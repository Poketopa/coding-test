import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> node = new ArrayList<>();
        for(int i=0;i<=n;i++) node.add(new ArrayList<>());
        
        for(int i=0;i<roads.length;i++){
            node.get(roads[i][0]).add(roads[i][1]);
            node.get(roads[i][1]).add(roads[i][0]);
        }
        
        Queue<int[]> queue = new LinkedList<>(); // 노드, 비용
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        queue.add(new int[]{destination, 0});
        visited[destination] = 0;
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i=0;i<node.get(temp[0]).size();i++){
                if(visited[node.get(temp[0]).get(i)] > temp[1] + 1){
                    visited[node.get(temp[0]).get(i)] = temp[1] + 1;
                    queue.add(new int[]{node.get(temp[0]).get(i), temp[1] + 1});
                }
            }
        }
    
        
        for(int i=1;i<=sources.length;i++){
            if(visited[sources[i-1]] == Integer.MAX_VALUE){
                answer[i-1] = -1;
            } else answer[i-1] = visited[sources[i-1]];
        }
        
        return answer;
    }
}