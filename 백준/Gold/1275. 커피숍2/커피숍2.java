
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new long[N * 4];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st2.nextToken());
        buildTree(1, 1, N);
        for(int i=0;i<Q;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            if(x < y) bw.write(sumTree(1, 1, N, x, y) + "\n");
            else bw.write(sumTree(1, 1, N, y, x) + "\n");
            changeTree(1, 1, N, a, b);
        }
        bw.flush();
        bw.close();
    }
    private static long changeTree(int node, int start, int end, int index, int newNum){
        if(start > index || end < index) return tree[node];
        if(start == end){
            arr[index] = newNum;
            tree[node] = newNum;
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = changeTree(node * 2, start, mid, index, newNum) + changeTree(node * 2 + 1, mid + 1, end, index, newNum);
        return tree[node];
    }

    private static long sumTree(int node, int start, int end, int left, int right){
        if(end < left || start > right) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sumTree(node * 2, start, mid, left, right) + sumTree(node * 2 + 1, mid + 1, end, left, right);
    }

    private static long buildTree(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = buildTree(node * 2, start, mid) + buildTree(node * 2 + 1, mid + 1, end);
        return tree[node];
    }
}
