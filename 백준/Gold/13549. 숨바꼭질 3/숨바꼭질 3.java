

import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else return 0;
        });
        int time = 0;
        int[] visited = new int[200001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        queue.add(new int[]{start, time});
        visited[start] = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if (temp[0] == end) { // 도착하면 즉시 종료
                System.out.println(temp[1]);
                return;
            }
            if (visited[temp[0]] < temp[1]) {
                continue;
            }
            if (temp[0] + 1 < 200001 && visited[temp[0] + 1] > temp[1] + 1) {
                visited[temp[0] + 1] = temp[1] + 1;
                queue.add(new int[]{temp[0] + 1, temp[1] + 1});
            }
            if (0 <= temp[0] - 1 && visited[temp[0] - 1] > temp[1] + 1) {
                visited[temp[0] - 1] = temp[1] + 1;
                queue.add(new int[]{temp[0] - 1, temp[1] + 1});
            }
            if (temp[0] * 2 < 200001 && visited[temp[0] * 2] > temp[1]) {
                visited[temp[0] * 2] = temp[1];
                queue.add(new int[]{temp[0] * 2, temp[1]});
            }


        }
    }
}
