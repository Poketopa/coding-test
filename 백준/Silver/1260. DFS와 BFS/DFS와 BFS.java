

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.valueOf(st.nextToken());
        int edge = Integer.valueOf(st.nextToken());
        int start = Integer.valueOf(st.nextToken());
        List<Integer>[] list = new List[node+1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<edge;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st2.nextToken());
            int to = Integer.valueOf(st2.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for(int i=0;i<list.length;i++){
            Collections.sort(list[i]);
        }

        // DFS 시작
        int[] visited1 = new int[node+1];
        dfs(visited1, list, start);

        System.out.println("");
        // BFS 시작
        int[] visited2 = new int[node+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(visited2[temp] == 1) continue;
            visited2[temp] = 1;
            System.out.print(temp+" ");
            for(int i=0;i<list[temp].size();i++){
                queue.add(list[temp].get(i));
            }
        }
    }

    private static void dfs(int[] visited, List<Integer>[] list, int now){
        if(visited[now] == 1) return;
        visited[now] = 1;
        System.out.print(now+" ");

        for(int i=0;i<list[now].size();i++){
            dfs(visited, list, list[now].get(i));
        }
    }
}