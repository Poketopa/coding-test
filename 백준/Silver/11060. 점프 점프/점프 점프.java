import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number[] = new int[input];
        int[] visited = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0] = 1;
        while(!queue.isEmpty()){
            int[]temp = queue.poll();
            if(temp[0] == input-1) {
                System.out.println(temp[1]);
                return;
            }
            for(int i=temp[0] + 1;i<=temp[0] + number[temp[0]];i++){
                if(i >= input || visited[i] == 1) continue;
                queue.add(new int[]{i, temp[1] + 1});
                visited[i] = 1;
            }
        }
        System.out.print("-1");
    }
}






