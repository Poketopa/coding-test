import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int[][] route = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                route[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        // j 번째 마을에서 시작하는 경우
        for(int j=0;j<input;j++){
            min = Integer.MAX_VALUE;
            int[] visited = new int[input];
            // 시작 마을 방문 표시
            visited[j] = 1;
            // i번째 마을 방문
            for(int i=0;i<input;i++){
                // 길 없으면 못감
                if(route[j][i] == 0) continue;
                dfs(route, 1, i, route[j][i], visited, j);
            }
        }
        System.out.println(min);
    }

    private static void dfs(int[][] route, int count, int now, int sum, int[] visited, int start){
        // 방문했으면 리턴
        if(visited[now] == 1) return;
        if(count == route.length-1){
            if(route[now][start] != 0 && (sum + route[now][start])<min){
                min = sum + route[now][start];
                return;
            }
        }
        visited[now] = 1;

        for(int i=0;i<route.length;i++){
            if(route[now][i] == 0) continue;
            dfs(route, count + 1, i, sum + route[now][i], visited, start);
        }
        visited[now] = 0;
    }

}