import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        public Node(int position, int distance){
            this.position = position;
            this.distance = distance;
        }
        int position;
        int distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int shorcut = Integer.parseInt(st.nextToken());
        int highway = Integer.parseInt(st.nextToken());
        int[][] shorcuts = new int[shorcut][3];
        for(int i=0;i<shorcut;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());
            shorcuts[i][0] = start;
            shorcuts[i][1] = end;
            shorcuts[i][2] = distance;
        }
        int[] visited = new int[highway + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            int count = 0;
            for(int i=0;i<shorcut;i++){
                if(shorcuts[i][0] < temp.position) continue;
                if(shorcuts[i][1] > highway) continue;
                if(shorcuts[i][1] - shorcuts[i][0] < shorcuts[i][2]) continue;
                count++;
                // visited 확인
                int goToStartOfShortcut = shorcuts[i][0] - temp.position;
                int newDistance = temp.distance + goToStartOfShortcut + shorcuts[i][2];
                int newPosition = shorcuts[i][1];
                if(visited[newPosition] > newDistance){
                    queue.add(new Node(newPosition, newDistance));
                    visited[newPosition] = newDistance;
                }
            }
            if(count == 0){
                visited[highway] = Math.min(visited[highway], temp.distance + (highway - temp.position));
            }
        }

        System.out.print(visited[highway]);
    }
}
