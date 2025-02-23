

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
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(number);
        List<Integer> list = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        int[] visited = new int[input];

        for(int i=0;i<number.length;i++){
            dfs(number, length, list, map, i, visited);
        }

    }

    private static void dfs(int[] number, int length, List<Integer> list, Map<String, Boolean> map, int now, int[] visited){
        visited[now] = 1;
        list.add(number[now]);

        if(list.size() == length){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<length;i++) {
                sb.append(list.get(i));
                sb.append("/");
            }
            if(map.containsKey(sb.toString())){
                visited[now] = 0;
                list.remove(list.size()-1);
                return;
            }
            else{
                map.put(sb.toString(), true);
                for(int i=0;i<length;i++) System.out.print(list.get(i)+" ");
                System.out.println("");
                visited[now] = 0;
                list.remove(list.size()-1);
                return;
            }
        }
        for(int i=0;i<number.length;i++){
            if(visited[i] == 0){
                dfs(number, length, list, map, i, visited);
            }

        }
        visited[now] = 0;
        list.remove(list.size()-1);
    }
}