
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        arr = new int[input + 1];
        tree = new int[input * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= input; i++) arr[i] = Integer.parseInt(st.nextToken());

        buildTree(1, 1, input);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            if (a == 1) { // 값 변경
                changeTree(1, 1, input, b, c);
            } else { // 구간 최소값 출력
                bw.write(sumTree(1, 1, input, b, c) + "\n");
            }
        }

        bw.flush(); // ✅ 출력 버퍼 비우기
        bw.close();
    }

    private static int buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int a = buildTree(node * 2, start, mid);
        int b = buildTree(node * 2 + 1, mid + 1, end);

        if (arr[a] > arr[b]) tree[node] = b;
        else tree[node] = a;

        return tree[node];
    }

    private static int sumTree(int node, int start, int end, int left, int right) {
        if (end < left || start > right) return -1; // 범위를 벗어난 경우
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        int a = sumTree(node * 2, start, mid, left, right);
        int b = sumTree(node * 2 + 1, mid + 1, end, left, right);

        if (a == -1) return b;
        if (b == -1) return a;

        if (arr[a] > arr[b]) return b;
        else return a;
    }

    private static int changeTree(int node, int start, int end, int index, int newNum) {
        if (start > index || end < index) return tree[node];

        if (start == end) {
            arr[index] = newNum;
            tree[node] = index;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int a = changeTree(node * 2, start, mid, index, newNum);
        int b = changeTree(node * 2 + 1, mid + 1, end, index, newNum);

        if (arr[a] > arr[b]) tree[node] = b;
        else tree[node] = a;

        return tree[node];
    }
}
