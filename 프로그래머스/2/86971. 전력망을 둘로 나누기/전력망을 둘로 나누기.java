import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        // 1 - [3]
        // 2 - [3]
        // 3 - [1, 2, 4]
        // 4 - [3, 5, 6, 7]
        // 5 - [4]
        // 6 - [4]
        // 7 - [4, 8, 9]
        // 8 - [7]
        // 9 - [7]
        // 배열 생성
        List<Integer>[] node = new List[n+1];
        // 방문 확인
        int[] visited = new int[node.length];
        // 배열에 리스트 할당
        for(int i=0;i<node.length;i++) node[i] = new ArrayList<>();
        // 리스트에 노드 추가
        for(int i=0;i<wires.length;i++){
            node[wires[i][0]].add(wires[i][1]);
            node[wires[i][1]].add(wires[i][0]);
        }
        // for문으로 간선 하나씩 정해서 해당 간선이면 continue
        //
        for(int i=0;i<wires.length;i++){
            for(int w=0;w<visited.length;w++){
                visited[w] = 0;
            }
            // 큐 생성
            Queue<Integer> queue = new LinkedList<>();
            int index = 1;
            int count = 0;
            // 들어갈 수 있는 노드를 찾는다 (찾으면 break)
            x:
            for(int j=1;j<node.length;j++) {
                for(int k=0;k<node[j].size();k++){
                    if(j==wires[i][0]&&wires[i][1]==node[j].get(k)||
                            j==wires[i][1]&&wires[i][0]==node[j].get(k)) continue;
                    else{
                        for(int q=0;q<node[j].size();q++){
                            if(j==wires[i][0]&&wires[i][1]==node[j].get(k)||
                                    j==wires[i][1]&&wires[i][0]==node[j].get(k)) continue;
                            queue.offer(j);
                            break;
                        }
                        int result = bfs(queue, node, wires, count, n, i, visited);
                        if(result<answer) answer = result;
                        break x;
                    }
                }
            }
        }
        return answer;
    }

    private static int bfs(Queue<Integer> queue, List<Integer>[] node, int[][] wire, int count, int n, int ignoreIndex, int[] visited){
        while(!queue.isEmpty()){
            int pop = queue.poll();
            visited[pop] = 1;
            count++;
            for(int i=0;i<node[pop].size();i++){
                if(pop==wire[ignoreIndex][0]&&node[pop].get(i)==wire[ignoreIndex][1]||
                        pop==wire[ignoreIndex][1]&&node[pop].get(i)==wire[ignoreIndex][0]) continue;
                if(visited[node[pop].get(i)]==1) continue;
                queue.offer(node[pop].get(i));
            }
        }
        return Math.abs(2*count - n);
    }
}