

import java.io.*;
import java.util.*;

public class Main {
    static long[] minTree, maxTree, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        minTree = new long[N * 4];
        maxTree = new long[N * 4];
        arr = new long[N + 1];
        for(int i=0;i<N;i++){
            arr[i + 1] = Long.parseLong(br.readLine());
        }
        makeMinTree(1, 1, N);
        makeMaxTree(1, 1, N);

        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            long min = findMinTree(1, 1, N, a, b);
            long max = findMaxTree(1, 1, N, a, b);
            System.out.println(min +" "+max);
        }
    }

    private static long findMinTree(int node, int start, int end, int left, int right){
        if(start > right || end < left) return Long.MAX_VALUE;

        if(left <= start && end <= right) return minTree[node];

        int mid = (start + end) / 2;
        return Math.min(findMinTree(node * 2, start, mid, left, right), findMinTree(node * 2  + 1, mid + 1, end, left, right));
    }

    private static long findMaxTree(int node, int start, int end, int left, int right){
        if(start > right || end < left) return Long.MIN_VALUE;

        if(left <= start && end <= right) return maxTree[node];

        int mid = (start + end) / 2;
        return Math.max(findMaxTree(node * 2, start, mid, left, right), findMaxTree(node * 2 + 1, mid + 1, end, left, right));
    }

    private static long makeMaxTree(int node, int start, int end){
        if(start == end){
            maxTree[node] = arr[start];
            return maxTree[node];
        }

        int mid = (start + end) / 2;
        maxTree[node] = Math.max(makeMaxTree(node * 2, start, mid), makeMaxTree(node * 2 + 1, mid + 1, end));
        return maxTree[node];
    }

    private static long makeMinTree(int node, int start, int end){
        if(start == end){
            minTree[node] = arr[start];
            return minTree[node];
        }

        int mid = (start + end) / 2;
        minTree[node] = Math.min(makeMinTree(node * 2, start, mid), makeMinTree(node * 2 + 1, mid + 1, end));
        return minTree[node];
    }
}