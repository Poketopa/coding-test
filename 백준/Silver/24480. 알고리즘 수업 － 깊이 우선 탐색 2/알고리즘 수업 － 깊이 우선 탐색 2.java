import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[node + 1];
        for(int i=1;i<=node;i++) list[i] = new ArrayList<>();
        for(int i=0;i<edge;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1;i<=node;i++) Collections.sort(list[i], Collections.reverseOrder());

        int[] answer = new int[node + 1];
        int[] visited = new int[node + 1];

        answer[start] = 1;
        count++;
        visited[start] = 1;
        dfs(list, answer, visited, start);
        for(int i=1;i<=node;i++) System.out.println(answer[i]);
    }

    public static void dfs(List<Integer>[] list, int[] answer, int[] visited, int now){
        for(int i=0;i<list[now].size();i++){
            if(visited[(list[now].get(i))] == 1) continue;
            answer[list[now].get(i)] = count;
            count++;
            visited[list[now].get(i)] = 1;
            dfs(list, answer, visited, list[now].get(i));
        }
    }
}
