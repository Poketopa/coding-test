import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st2.nextToken());
        int sum = 0;
        int[] visited = new int[input];

        for(int i=0;i<input;i++){
            dfs(number, i, sum, target, visited);
        }


        System.out.println(count);
    }
    private static void dfs(int[] number, int now, int sum, int target, int[] visited){
        visited[now] = 1;
        sum += number[now];
        if(sum == target){
            count++;
        }
        for(int i=now + 1;i<number.length;i++){
            dfs(number, i, sum, target, visited);
        }
        visited[now] = 0;
    }
}
