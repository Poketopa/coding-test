import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=1;i<list.length;i++) Collections.sort(list[i]);
        int[] visited = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        int count = 1;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=0;i<list[temp].size();i++){
                if(visited[list[temp].get(i)] != 0) continue;
                count++;
                queue.add(list[temp].get(i));
                visited[list[temp].get(i)] = count;
            }
        }
        for(int i=1;i<=N;i++) System.out.println(visited[i]);
    }
}






