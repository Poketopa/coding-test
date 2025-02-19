
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int choose = Integer.parseInt(st.nextToken());
        int[] number = new int[input];
        StringTokenizer num = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(num.nextToken());
        Arrays.sort(number);
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[input];
        for(int i=0;i<input;i++){
            dfs(number, choose, visited, i, list);
        }

    }

    private static void dfs(int[] number, int length, int[] visited, int now, List<Integer> list){
        list.add(number[now]);
        if(list.size() == length){
            for(int i=0;i<length;i++) System.out.print(list.get(i)+" ");
            System.out.println("");
            list.remove(list.size()-1);
            visited[now] = 0;
            return;
        }
        visited[now] = 1;

        for(int i=0;i<number.length;i++){
            if(visited[i] == 1) continue;
            dfs(number, length, visited, i, list);
        }
        list.remove(list.size()-1);
        visited[now] = 0;
    }
}