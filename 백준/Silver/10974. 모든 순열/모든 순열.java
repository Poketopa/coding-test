import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        for(int i=1;i<=input;i++){
            number[i-1] = i;
        }
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[input];
        for(int i=0;i<input;i++){
            visited[i] = 1;
            dfs(list, number, input, i, visited);
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }
    public static void dfs(List<Integer> list, int[] number, int input, int now, int[] visited){
        list.add(number[now]);
        if(list.size() == input){
            for(int i=0;i<input;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println("");
            return;
        }
        for(int i=0;i<input;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(list, number, input, i, visited);
                visited[i] = 0;
                list.remove(list.size()-1);
            }
        }

    }
}
