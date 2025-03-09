
import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        List<int[]>[] list = new List[node + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<edge;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st2.nextToken());
            int temp2 = Integer.parseInt(st2.nextToken());
            int temp3 = Integer.parseInt(st2.nextToken());
            list[temp1].add(new int[]{temp2, temp3});
        }
        int[] distance = new int[node+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else return 0;
        });
        queue.add(new int[]{start, 0});
        distance[start] = 0;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int now = temp[0];
            int cost = temp[1];

            if(cost > distance[now]) continue;

            for(int i=0;i<list[now].size();i++){
                if(distance[list[now].get(i)[0]] > cost + list[now].get(i)[1]){
                    distance[list[now].get(i)[0]] = cost + list[now].get(i)[1];
                    queue.add(new int[]{list[now].get(i)[0], cost + list[now].get(i)[1]});
                }
            }
        }

        for(int i=1;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}
