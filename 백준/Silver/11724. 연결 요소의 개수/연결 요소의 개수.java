
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(input.nextToken());
        int edge = Integer.parseInt(input.nextToken());
        List<Integer>[] list = new List[node+1];
        for(int i=0;i<node+1;i++) list[i] = new ArrayList<>();
        int[] visited = new int[node+1];
        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int count = 0;
        for(int i=1;i<=node;i++){
            Queue<Integer> queue = new LinkedList<>();
            // 큐 만들어서 탐험하기, 탐험하면 visited 갱신, count만들어서 세기
            if(visited[i] == 0) {
                queue.add(i);
                count++;
            }
            else continue;
            while(!queue.isEmpty()){
                int temp = queue.poll();
                if(visited[temp] == 1) continue;
                visited[temp] = 1;
                for(int j=0;j<list[temp].size();j++){
                    if(visited[list[temp].get(j)] == 0){
                        queue.add(list[temp].get(j));
                    }
                }
            }
        }
        System.out.println(count);
    }
}