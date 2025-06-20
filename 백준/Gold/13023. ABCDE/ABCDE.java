import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list= new ArrayList[N];
        for(int i=0;i<N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        List<Integer> number = new ArrayList<>();
        int[] visited = new int[N];

        for(int i=0;i<N;i++){
            dfs(number, i, N, M, list, visited, 0);
        }
        if(flag) System.out.println("1");
        else System.out.println("0");
    }
    public static void dfs(List<Integer> number, int now, int N, int M, List<Integer>[] list, int[]visited, int count){
        if(number.size() > 5) return;
        number.add(now);
        if(flag) return;
        visited[now] = 1;

        for(int i=0;i<list[now].size();i++){
            if(visited[list[now].get(i)] == 0){
                dfs(number, list[now].get(i), N, M, list, visited, count);
            } else{
                if(i == list[now].size()-1 && number.size() == 5){
                    flag = true;
                    return;
                }
            }
            if(flag) break;
        }
        visited[now] = 0;
        number.remove(number.size()-1);
    }
}