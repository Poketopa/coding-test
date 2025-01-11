import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int n, int[][] costs) {
        List<int[]>[] map = new List[n];
        for(int i=0;i<map.length;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<costs.length;i++){
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            map[start].add(new int[]{end, cost});
            map[end].add(new int[]{start, cost});
        }

        int[] visited = new int[n];
        int count = 0;
        int now = 0;

        List<Integer> history = new ArrayList<>();

        // 0에서 시작
        visited[0] = 1;
        history.add(0);
        while(history.size()!=n){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            // 현재 찾은 것들에서
            for(int i=0;i<history.size();i++){
                // 가장 짧은 것들 확인
                for(int j=0;j<map[history.get(i)].size();j++){
                    if(visited[map[history.get(i)].get(j)[0]] == 1) continue;
                    if(min>map[history.get(i)].get(j)[1]) {
                        min = map[history.get(i)].get(j)[1];
                        minIndex = map[history.get(i)].get(j)[0];
                    }
                }
            }
            history.add(minIndex);
            count += min;
            visited[minIndex] = 1;
        }

        return count;
    }
}