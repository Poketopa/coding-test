

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[input+1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        int[] visited = new int[input+1];

        for(int i=0;i<input-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int[] answer = new int[input+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            visited[temp] = 1;
            for(int i=0;i<list[temp].size();i++){
                if(visited[list[temp].get(i)] == 1) continue;
                queue.add(list[temp].get(i));
                answer[list[temp].get(i)] = temp;
            }
        }

        for(int i=2;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
}