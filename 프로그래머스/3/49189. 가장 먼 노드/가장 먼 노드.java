import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        // 1. 노트 배열 만들기 int[ list<int[]> ]  시작 노드 [ [끝 노드, 몇번째 탐색]]
        List<Integer>[] node = new List[n+1];
        for(int i=0;i<node.length;i++) node[i] = new ArrayList<>();
        for(int i=0;i<vertex.length;i++){
            node[vertex[i][0]].add(vertex[i][1]);
            node[vertex[i][1]].add(vertex[i][0]);
        }
        int[] visited = new int[n+1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0});
        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        // 2. bfs 탐색, visited 확인, count로 몇 번째 탐색인지 확인
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(visited[temp[0]] == 1) continue;
            visited[temp[0]] = 1;
            map.put(temp[1], map.getOrDefault(temp[1], 0) + 1);
            if(max<temp[1]) max = temp[1];


            for(int i=0;i<node[temp[0]].size();i++){
                if(visited[node[temp[0]].get(i)] == 1){
                    continue;
                }
                queue.add(new int[]{node[temp[0]].get(i), temp[1] + 1});
            }
        }

        return map.get(max);






    }
}
