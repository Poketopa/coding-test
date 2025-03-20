
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(br.readLine());
        parent = new int[node + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[2] < b[2]) return -1;
            else if (a[2] > b[2]) return 1;
            else return 0;
        });
        long sum = 0;
        for (int i = 0; i <= node; i++) parent[i] = i;

        for (int i = 1; i <= node; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=node;j++){

                int a = Integer.parseInt(st.nextToken());
                if(i==j)continue;
                queue.add(new int[]{i, j, a});
            }
        }

        long answer = 0;
        long count = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty() && count < node - 1) {
            int[] temp = queue.poll();
            int a = temp[0];
            int b = temp[1];
            int weight = temp[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer +=weight;
                count++;
                max = Math.max(weight, max);
            }
        }
        System.out.println(answer);

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
