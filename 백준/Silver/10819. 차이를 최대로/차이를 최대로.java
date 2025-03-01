

import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[input];
        for(int i=0;i<input;i++){
            dfs(number, input, list, i, visited);
        }
        System.out.println(max);
    }

    private static void dfs(int[] number, int input, List<Integer> list, int now, int[] visited){
        list.add(number[now]);
        if(list.size() == input){
            int temp = 0;
            for(int i=0;i<input-1;i++){
                temp += Math.abs(list.get(i) - list.get(i+1));
            }
            max = Math.max(max, temp);
            list.remove(list.size()-1);
            return;
        }
        visited[now] = 1;

        for(int i=0;i<input;i++){
            if(visited[i] == 1) continue;
            dfs(number, input, list, i, visited);
        }
        list.remove(list.size()-1);
        visited[now] = 0;
    }
}
