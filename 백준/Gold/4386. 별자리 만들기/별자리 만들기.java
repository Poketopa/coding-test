

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(br.readLine());
        List<double[]>[] list = new List[node + 1];
        double[][] input = new double[node + 1][2];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        parent = new int[node + 1];
        for(int i=0;i<=node;i++) parent[i] = i;
        for(int i=1;i<=node;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            input[i][0] = a;
            input[i][1] = b;
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b)->{
            if(a[2] < b[2]) return -1;
            else if(a[2] > b[2]) return 1;
            else return 0;
        });
        for(int i=1;i<node;i++){
            for(int j=i+1;j<=node;j++){
                double distance = Math.sqrt(
                        Math.pow(input[i][0] - input[j][0], 2) + Math.pow(input[i][1] - input[j][1], 2));
                queue.add(new double[]{i, j, distance});
            }
        }
        double answer = 0;
        int count = 0;

        while(!queue.isEmpty() && count < node -1){
            double[] temp = queue.poll();
            int a = (int) temp[0];
            int b = (int) temp[1];
            double weight = temp[2];

            if(find(a) != find(b)){
                union(a, b);
                answer += weight;
                count++;
            }
        }
        System.out.printf("%.2f", answer);

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
