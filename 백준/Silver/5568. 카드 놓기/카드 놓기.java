import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int pick = Integer.parseInt(br.readLine());
        String[] number = new String[input];
        for(int i=0;i<input;i++) number[i] = br.readLine();

        List<String> list = new ArrayList<>();

        int[] visited = new int[input];

        Map<String, Boolean> map = new HashMap<>();

        for(int i=0;i<input;i++){
            dfs(number, list, visited, pick, i, map);
            list.remove(list.size()-1);
            visited[i] = 0;
        }

        System.out.print(count);
    }

    public static void dfs(String[] number, List<String> list, int[] visited, int pick, int now, Map<String, Boolean> map){
        list.add(number[now]);
        visited[now] = 1;
        if(list.size() == pick){
            String temp = "";
            for(String i : list) temp += i;
            if(!map.containsKey(temp)){
                count++;
                map.put(temp, true);
            }
            return;
        }
        for(int i=0;i<number.length;i++) {
            if(visited[i] == 1) continue;
            dfs(number, list, visited, pick, i, map);
            list.remove(list.size()-1);
            visited[i] = 0;
        }
    }
}






