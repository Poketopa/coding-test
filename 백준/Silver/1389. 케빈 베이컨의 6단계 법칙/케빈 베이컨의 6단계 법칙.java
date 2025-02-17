

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(input.nextToken());
        int edge = Integer.parseInt(input.nextToken());
        List<Integer>[] list = new ArrayList[node+1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for(int i=1;i<=node;i++){
            int sum = 0;
            int count = node-1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, 1});
            int[] visited = new int[node+1];
            visited[i] = 1;
            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                for(int j=0;j<list[temp[0]].size();j++){
                    if(visited[list[temp[0]].get(j)] == 0){
                        visited[list[temp[0]].get(j)] = 1;
                        sum += temp[1];
                        queue.add(new int[]{list[temp[0]].get(j), temp[1]+1});
                    }
                }
            }
            if(sum<=min[0]){
                if(sum == min[0]){
                    if(i<min[1]) min[1] = i;
                }
                else{
                    min[0] = sum;
                    min[1] = i;
                }
            }
        }
        System.out.println(min[1]);
    }
}