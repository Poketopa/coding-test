
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        parent = new int[m];
        for(int i=0;i<m;i++) parent[i] = i;
        for(int i=0;i<n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            if(union(find(a), find(b))){
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("0");
        bw.flush();
        bw.close();
    }
    private static boolean union(int a, int b){
        int rootA = parent[a];
        int rootB = parent[b];
        if(rootA == rootB) return true;
        else{
            parent[rootB] = rootA;
            return false;
        }
    }

    private static int find(int x){
        if(x == parent[x]) return x;
        else return find(parent[x]);
    }


}

