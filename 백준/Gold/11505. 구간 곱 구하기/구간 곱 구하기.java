

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new long[N * 4];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
        buildTree(1, 1, N);
        for(int i=0;i<M + K;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            if(a == 1){ // 변경
                changeTree(1, 1, N, b, c);
            }
            else{
                System.out.println(findSum(1, 1, N, b, c));
            }
        }

    }
    private static long findSum(int node, int start, int end, int left, int right){
        if(start > right || end < left) return 1;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return (findSum(node * 2, start, mid, left, right) * findSum(node * 2 + 1, mid + 1, end, left, right)) % 1000000007;
    }

    private static long changeTree(int node, int start, int end, int index, int changeNum){
        if(end < index || start > index) return tree[node];

        if(start == end) {
            arr[index] = changeNum;
            tree[node] = changeNum;
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = (changeTree(node * 2, start, mid, index, changeNum) * changeTree(node * 2 + 1, mid + 1, end, index, changeNum)) % 1000000007;
        return tree[node];
    }

    private static long buildTree(int node, int start, int end){
        if(start == end) {
            tree[node] = arr[start];
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = (buildTree(node * 2, start, mid) * buildTree(node * 2 + 1, mid + 1, end)) % 1000000007;
        return tree[node];
    }
}