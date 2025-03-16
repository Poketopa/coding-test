
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
        arr = new int[N + 1];
        tree = new long[N * 4];
        for(int i = 0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            if(a == 1){ // 수정
                changeTree(1, 1, N, b, c);

            }
            else{ // 합
                if(b<c) System.out.println(sumTree(1, 1, N, b, c));
                else System.out.println(sumTree(1, 1, N, c, b));
            }
        }
    }
    private static long sumTree(int node, int start, int end, int left, int right){
        if(end < left || start > right) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sumTree(node * 2, start, mid, left, right) + sumTree(node * 2 + 1, mid + 1, end, left, right);
    }

    private static long changeTree(int node, int start, int end, int index, int newNum){
        if(start > index || end < index) return tree[node];
        if(start == end){
            arr[index] = newNum;
            tree[node] = newNum;
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = changeTree(node * 2, start, mid, index, newNum) + changeTree(node*2 + 1, mid + 1, end, index, newNum);
        return tree[node];
    }
}
