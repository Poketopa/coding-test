import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            num = new int[node + 1];
            tree = new int[node * 4];

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 1; i <= node; i++) {
                int temp = Integer.parseInt(st2.nextToken());
                if (temp > 0) num[i] = 1;
                else if (temp < 0) num[i] = -1;
                else num[i] = 0;
            }

            buildTree(1, 1, node);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < edge; i++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                String s = st3.nextToken();
                int a = Integer.parseInt(st3.nextToken());
                int b = Integer.parseInt(st3.nextToken());

                if (s.equals("C")) {
                    if (b > 0) b = 1;
                    else if (b < 0) b = -1;
                    else b = 0;
                    changeTree(1, 1, node, a, b);
                } else {
                    int result = sumTree(1, 1, node, a, b);
                    if (result == 1) sb.append("+");
                    else if (result == -1) sb.append("-");
                    else sb.append("0");
                }
            }

            bw.write(sb.toString());  // 결과 한 줄 출력
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }

    private static int sumTree(int node, int start, int end, int left, int right) {
        if (end < left || start > right) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sumTree(node * 2, start, mid, left, right) * sumTree(node * 2 + 1, mid + 1, end, left, right);
    }

    private static void changeTree(int node, int start, int end, int index, int newNum) {
        if (end < index || start > index) return;
        if (start == end) {
            tree[node] = newNum;
            return;
        }
        int mid = (start + end) / 2;
        changeTree(node * 2, start, mid, index, newNum);
        changeTree(node * 2 + 1, mid + 1, end, index, newNum);
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    private static int buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = buildTree(node * 2, start, mid) * buildTree(node * 2 + 1, mid + 1, end);
        return tree[node];
    }
}
