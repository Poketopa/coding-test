
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int finder = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int count = 0;
        if(finder == 0 && target == 0){
            System.out.println("0");
            return;
        }
        int[] visited = new int[Math.max(finder, target)*3];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{finder, 0});
        visited[finder] = 1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == target){
                System.out.println(temp[1]);
                return;
            }
            if(temp[0]<target && visited[temp[0]+1] == 0){
                visited[temp[0]+1] = 1;
                queue.add(new int[]{temp[0]+1, temp[1]+1});
            }
            if(temp[0]<target&& visited[temp[0]*2] == 0){
                visited[temp[0]*2] = 1;
                queue.add(new int[]{temp[0]*2, temp[1]+1});
            }
            if(temp[0]>0 && visited[temp[0]-1] == 0){
                visited[temp[0]-1] = 1;
                queue.add(new int[]{temp[0]-1, temp[1]+1});
            }
        }

    }
}