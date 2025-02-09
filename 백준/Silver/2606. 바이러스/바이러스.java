import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드개수 7개
        int node = Integer.valueOf(br.readLine());
        // 간선개수 6개
        int line = Integer.valueOf(br.readLine());
        int[] visited = new int[node+1];
        List<Integer>[] list = new List[node+1];
        for(int i=0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(visited[now] == 1) continue;
            visited[now] = 1;
            
            for(int i=0;i<list[now].size();i++){
                if(visited[list[now].get(i)] == 0){
                    queue.add(list[now].get(i));
                }
            }
        }
        int answer = 0;
        for(int i=1;i<visited.length;i++){
            if(i==1) continue;
            if(visited[i] == 1 )answer++;
        }
        System.out.println(answer);
        
        
        
    }
}