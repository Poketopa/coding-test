import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<int[]>[] list = new List[V + 1];
        for(int i=0;i<=V;i++) list[i] = new ArrayList<>();

        for(int i=0;i<E;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());
            list[start].add(new int[]{end, distance});
            list[end].add(new int[]{start, distance});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[][] distance = new int[V + 1][2]; // 0 건우없다 /  1 건우있다
        for(int i=0;i<V + 1;i++) distance[i][0] = Integer.MAX_VALUE;

        if (P == 1) {
            queue.add(new int[]{1, 0, 1});
            distance[1][1] = 1;
        }
        else{
            queue.add(new int[]{1, 0, 0});// 현재 위치, 현재 거리, 건우있없
        }
        distance[1][0] = 0;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i=0;i<list[temp[0]].size();i++){
                int newDistance = temp[1] + list[temp[0]].get(i)[1];
                int newPosition = list[temp[0]].get(i)[0];
                if(temp[0] == P) {
                    temp[2] = 1;
                    distance[temp[0]][1] = 1;
                }
                if(distance[newPosition][0] > newDistance){
                    distance[newPosition][0] = newDistance;
                    distance[newPosition][1] = distance[temp[0]][1];
                    queue.add(new int[]{newPosition, newDistance, temp[2]});
                }
                else if(temp[2] == 1 && distance[newPosition][0] == newDistance){
                    distance[newPosition][1] = 1;
                    queue.add(new int[]{newPosition, newDistance, 1});
                }
            }
        }
        if(distance[V][1] == 1){
            System.out.print("SAVE HIM");
        } else System.out.print("GOOD BYE");

    }
}
