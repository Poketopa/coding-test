
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){
            StringTokenizer st5 = new StringTokenizer(br.readLine());
            if(st5.countTokens() == 0) continue;
            if(st5.countTokens() == 1) return;
            int node = Integer.parseInt(st5.nextToken());
            int edge = Integer.parseInt(st5.nextToken());
            if(edge == 0){
                System.out.println("0");
                continue;
            }
            parent = new int[node + 1];
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
                if(a[2] < b[2]) return -1;
                else if(a[2] > b[2]) return 1;
                else return 0;
            });
            for(int i=0;i<=node;i++) parent[i] = i;
            for(int i=1;i<=edge;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                queue.add(new int[]{a, b, c});
            }

            int answer = 0;
            int count = 0;

            while(!queue.isEmpty() && count < node -1){
                int[] temp = queue.poll();
                int a = temp[0];
                int b = temp[1];
                int weight = temp[2];

                if(find(a) != find(b)){
                    union(a, b);
                    answer += weight;
                    count++;
                }
            }
            System.out.println(answer);
        }


    }
    private static void union(int a, int b){
        int rootA = parent[a];
        int rootB = parent[b];
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    private static int find(int x){
        if(parent[x] == x) return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}
