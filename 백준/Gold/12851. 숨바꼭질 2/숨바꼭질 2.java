
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] visited = new int[200001];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
            if(a[1] < b[1]) return -1;
            else if(a[1] > b[1]) return 1;
            else return 0;
        });
        queue.add(new int[]{start, 0});
        visited[start] = 1;

        int max = Math.max(start, end);
        int count = 0;
        boolean flag = false;
        int min = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int now = temp[0];
            int move = temp[1];
            if(now == end){
                if(!flag){
                    flag = true;
                    min = move;
                }
                if(move == min) count++;
                continue;
            }
            else visited[now] = 1;

            int temp1 = now - 1;
            int temp2 = now + 1;
            int temp3 = now * 2;

            if(0<= temp1 && temp1 <= 200000 && visited[temp1] == 0) queue.add(new int[]{temp1, move + 1});
            if(0<= temp2 && temp2 <= 200000 && visited[temp2] == 0) queue.add(new int[]{temp2, move + 1});
            if(0<= temp3 && temp3 <= 200000 && visited[temp3] == 0) queue.add(new int[]{temp3, move + 1});
        }

        System.out.println(min);
        System.out.println(count);
    }
}


