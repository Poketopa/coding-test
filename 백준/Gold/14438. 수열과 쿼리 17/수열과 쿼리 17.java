

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        arr = new int[input + 1];
        tree = new long[input * 4];
        Arrays.fill(tree, Long.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= input; i++) arr[i] = Integer.parseInt(st.nextToken());

        buildTree(1, 1, input);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            if (a == 1) { // 변경
                changeTree(1, 1, input, b, c);
            } else { // 합
                bw.write(sumTree(1, 1, input, b, c) + "\n");
            }
        }

        bw.flush(); // ✅ 출력 버퍼 비우기
        bw.close();
    }

    private static long buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = Math.min(buildTree(node * 2, start, mid), buildTree(node * 2 + 1, mid + 1, end));
        return tree[node];
    }

    private static long sumTree(int node, int start, int end, int left, int right) {
        if (end < left || start > right) return Long.MAX_VALUE;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Math.min(sumTree(node * 2, start, mid, left, right),
                        sumTree(node * 2 + 1, mid + 1, end, left, right));
    }

    private static long changeTree(int node, int start, int end, int index, int newNum) {
        if (start > index || end < index) return tree[node];

        if (start == end) {
            arr[index] = newNum;
            tree[node] = newNum;
            return tree[node];
        }

        int mid = (start + end) / 2;
        tree[node] = Math.min(changeTree(node * 2, start, mid, index, newNum),
                              changeTree(node * 2 + 1, mid + 1, end, index, newNum));
        return tree[node];
    }
}
