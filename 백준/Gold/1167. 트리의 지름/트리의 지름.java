

import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int maxNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(br.readLine());
        List<int[]>[] list = new List[node + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();

        for(int i=0;i<node;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            while(true){
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                int b = Integer.parseInt(st.nextToken());
                list[nodeNum].add(new int[]{a, b});
            }
        }
        int sum = 0;
        int[] visited = new int[node + 1];
        dfs(1, list, 0, visited);
        max = Integer.MIN_VALUE;
        Arrays.fill(visited, 0);
        dfs(maxNode, list, 0, visited);
        System.out.println(max);
    }
    private static void dfs(int now, List<int[]>[] list, int sum, int[] visited){
        visited[now] = 1;
        if(sum > max){
            max = sum;
            maxNode = now;
        }

        for(int i=0;i<list[now].size();i++){
            if(visited[list[now].get(i)[0]] == 1) continue;
            dfs(list[now].get(i)[0], list, sum + list[now].get(i)[1], visited);
        }

        visited[now] = 0;
    }
}