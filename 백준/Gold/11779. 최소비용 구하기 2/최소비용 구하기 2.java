
import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        List<int[]>[] list = new List[node + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            int temp3 = Integer.parseInt(st.nextToken());
            list[temp1].add(new int[]{temp2, temp3});
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st2.nextToken());
        int end = Integer.parseInt(st2.nextToken());
        int[] distance = new int[node + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else return 0;
        });
        // now, cost, 횟수
        queue.add(new int[]{start, 0, 1});
        int move = 0;
        int[] moving = new int[node + 1];
        Arrays.fill(moving, -1);

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int now = temp[0];
            int cost = temp[1];
            int length = temp[2];

            if(distance[now] < cost) continue;

            for(int i=0;i<list[now].size();i++){
                if(distance[list[now].get(i)[0]] > cost + list[now].get(i)[1]){
                    distance[list[now].get(i)[0]] = cost + list[now].get(i)[1];
                    moving[list[now].get(i)[0]] = now;
                    if(list[now].get(i)[0] == end) move = length + 1;
                    queue.add(new int[]{list[now].get(i)[0], cost + list[now].get(i)[1], length + 1});
                }
            }
        }

        System.out.println(distance[end]);
        System.out.println(move);

        List<Integer> print = new ArrayList<>();
        for(int i = end; i != -1;i = moving[i]){
            print.add(i);
        }
        for(int i=print.size()-1;i>=0;i--){
            System.out.print(print.get(i)+" ");
        }
    }
}


