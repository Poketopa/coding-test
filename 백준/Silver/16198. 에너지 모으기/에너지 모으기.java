import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int[] visited = new int[input];

        for(int i=1;i<input-1;i++){
            dfs(input, number, i, visited);
        }
        System.out.println(max);

    }
    public static void dfs(int input, int[] number, int now, int[] visited){
        if(list.size() == input - 2){
            int[] sumed = new int[input];
            int sum = 0;
            for(int i : list){
                sum +=checkSum(number, sumed, i);
                sumed[i] = 1;
            }
            max = Math.max(max, sum);
        }
        for(int i=1;i<input-1;i++){
            if(visited[i] == 1) continue;
            list.add(i);
            visited[i] = 1;
            dfs(input, number, i, visited);
            list.remove(list.size()-1);
            visited[i] = 0;
        }

    }
    public static int checkSum(int[] number, int[] visited, int now){
        int left = now - 1;
        int right = now + 1;
        while(visited[left] == 1) left--;
        while(visited[right] == 1) right++;
        return number[left] * number[right];
    }
}
