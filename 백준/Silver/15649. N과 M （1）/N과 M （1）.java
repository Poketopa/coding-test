

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = i+1;
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[input];

        for(int i=0;i<input;i++){
            dfs(length, number, list, visited, i);
        }
    }

    private static void dfs(int length, int[] number, List<Integer> list, int[] visited, int now){
        list.add(number[now]);
        if(list.size() == length){
            for(int i=0;i<length;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println("");
            list.remove(list.size()-1);
            return;
        }
        visited[now] = 1;
        for(int i=0;i<number.length;i++){
            if(visited[i] == 1) continue;
            dfs(length, number, list, visited, i);
        }
        list.remove(list.size()-1);
        visited[now] = 0;
    }

}
