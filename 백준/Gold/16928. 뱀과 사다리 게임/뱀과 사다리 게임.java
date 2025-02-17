
import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(input.nextToken());
        int snake = Integer.parseInt(input.nextToken());
        int[] map = new int[101];
        int[] visited = new int[101];
        for(int i=0;i<ladder;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())]  = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<snake;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())]  = Integer.parseInt(st.nextToken());
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = 1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(map[temp[0]] != 0){
                temp[0] = map[temp[0]];
                visited[temp[0]] = 1;
            }
            if(temp[0] == 100){
                System.out.println(temp[1]);
                return;
            }
            for(int i=1;i<=6;i++){
                if(temp[0] + i > 100) continue;
                if(visited[temp[0] + i] == 1)continue;
                visited[temp[0] + i] = 1;
                queue.add(new int[]{temp[0] + i, temp[1]+1});
            }
        }
    }
}