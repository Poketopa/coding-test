
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        parent = new int[node + 1];
        for(int i=1;i<=node;i++) parent[i] = i;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[2]<b[2]) return -1;
            else if(a[2]>b[2]) return 1;
            else return 0;
        });
        for(int i=0;i<edge;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int weight = Integer.parseInt(st2.nextToken());
            queue.add(new int[]{a, b, weight});
        }
        int max = Integer.MIN_VALUE;
        int weightSum = 0;
        int edgeCount = 0;
        while(!queue.isEmpty() && edgeCount < node - 1){
            int[] temp = queue.poll();
            int a = temp[0];
            int b = temp[1];
            int weight = temp[2];
            if(find(a) != find(b)){
                union(a, b);
                weightSum += weight;
                edgeCount ++;
                max = Math.max(max, weight);
            }
        }
        System.out.println(weightSum - max);
    }
    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    private static int find(int x){
        if(x == parent[x]) return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}
