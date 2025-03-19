
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        parent = new int[node + 1];
        for(int i=1;i<=node;i++) parent[i] = i;
        for(int i=1;i<=node;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=1;j<=node;j++){
                int temp = Integer.parseInt(st2.nextToken());
                if(temp == 1){
                    if(find(i) != find(j)) union(i, j);
                }
            }
        }
        int now = 0;
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<edge;i++){
            int temp = Integer.parseInt(st3.nextToken());
            if(i != 0){
                if(find(now) != find(temp)){
                    System.out.println("NO");
                    return;
                }
            }
            now = temp;
        }
        System.out.println("YES");

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
