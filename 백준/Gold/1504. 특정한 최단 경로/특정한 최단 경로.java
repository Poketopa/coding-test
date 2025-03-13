
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        List<int[]>[] list = new List[node + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<edge;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st2.nextToken());
            int temp2 = Integer.parseInt(st2.nextToken());
            int temp3 = Integer.parseInt(st2.nextToken());
            list[temp1].add(new int[]{temp2, temp3});
            list[temp2].add(new int[]{temp1, temp3});
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st3.nextToken());
        int node2 = Integer.parseInt(st3.nextToken());

        // 1->v1
        int length1 = 0;
        // 1->v2
        int length2 = 0;
        // v1->v2
        int length3 = 0;
        // v1-n
        int length4 = 0;
        // v2->v1
        int length5 = 0;
        // v2->v
        int length6 = 0;
        for(int l=0;l<3;l++){
            int min = Integer.MAX_VALUE;
            PriorityQueue<int[]> queue =  new PriorityQueue<>((a,b)->{
                if(a[1] < b[1]) return -1;
                else if(a[1] > b[1]) return 1;
                else return 0;
            });
            int[] distance = new int[node + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            if(l == 0) distance[1] = 0;
            else if(l == 1) distance[node1] = 0;
            else distance[node2] = 0;

            // 노드, 코스트, 두개의 간선을 지났는지
            if(l == 0) queue.add(new int[]{1, 0});
            else if(l == 1) queue.add(new int[]{node1, 0});
            else queue.add(new int[]{node2, 0});


            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                int now = temp[0];
                int cost = temp[1];

                if(distance[now] < cost) continue;

                for(int i=0;i<list[now].size();i++){
                    if(distance[list[now].get(i)[0]] > cost + list[now].get(i)[1]){
                        distance[list[now].get(i)[0]] = cost + list[now].get(i)[1];
                        queue.add(new int[]{list[now].get(i)[0], cost + list[now].get(i)[1]});
                    }
                }
            }
            if(l == 0){
                length1 = distance[node1];
                length2 = distance[node2];
            }
            else if(l == 1){
                length3 = distance[node2];
                length4 = distance[node];
            }
            else {
                length5 = distance[node1];
                length6 = distance[node];
            }
        }
        boolean flag1 = false;
        if(length1 == Integer.MAX_VALUE || length3 == Integer.MAX_VALUE || length6 == Integer.MAX_VALUE) flag1 = true;
        int num1 = 0;
        if(flag1) num1 = Integer.MAX_VALUE;
        else num1 = length1 + length3 + length6;
        boolean flag2 = false;
        if(length2 == Integer.MAX_VALUE || length5 == Integer.MAX_VALUE || length4 == Integer.MAX_VALUE) flag2 = true;
        int num2 = 0;
        if(flag2) num2 = Integer.MAX_VALUE;
        else num2 = length2 + length5 + length4;
        
        if(flag1 && flag2) System.out.println("-1");
        else System.out.println(Math.min(num1, num2));
    }
}


