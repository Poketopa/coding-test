

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new long[N * 4];

        for(int i=0;i<M;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int c = Integer.parseInt(st1.nextToken());
            if(a == 1){ // 숫자 추가
                changeTree(1, 1, N, b, c);
            }
            else{ // 변화량 출력
                bw.write(findSum(1, 1, N, b, c) + "\n");
            }
        }

        bw.flush(); // ✅ 출력 버퍼 비우기
        bw.close();
    }
    private static long findSum(int node, int start, int end, int left, int right){
        if(end < left || start > right) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return findSum(node * 2, start, mid, left, right) + findSum(node * 2 + 1, mid + 1, end, left, right);
    }

    private static long changeTree(int node, int start, int end, int index, int newNum){
        if(end < index || start > index) return tree[node];
        if(start == end){
            arr[index] += newNum;
            tree[node] += newNum;
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = changeTree(node * 2, start, mid, index, newNum) + changeTree(node * 2 + 1, mid + 1, end, index, newNum);
        return tree[node];
    }
}
