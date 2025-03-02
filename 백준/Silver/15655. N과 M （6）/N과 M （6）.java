
import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(number);
        int[] visited = new int[input];
        List<Integer> list = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0;i<input;i++){

            dfs(length, number, visited, list, i, map);
        }
    }

    private static void dfs(int length, int[] number, int[] visited, List<Integer> list, int now, Map<String, Boolean> map){
        list.add(number[now]);
        if(list.size() == length){
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<length;i++){
                sb.append(list.get(i));
                sb.append("/");
            }
            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), true);
                for(int i=0;i<length;i++){
                    System.out.print(list.get(i)+" ");
                }
                System.out.println("");
            }
            list.remove(list.size()-1);
            return;
        }
        visited[now] = 1;

        for(int i=now+1;i<number.length;i++){
            if(visited[i] == 1) continue;
            dfs(length, number, visited, list, i, map);
        }
        list.remove(list.size()-1);
        visited[now] = 0;
    }
}
