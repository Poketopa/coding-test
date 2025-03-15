
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new int[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeTree(1, 1, N);

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st2.nextToken());
            int right = Integer.parseInt(st2.nextToken());
            int result = findTree(1, 1, N, left, right);
            bw.write(result + "\n");  // ✅ 버퍼에 저장
        }

        bw.flush();  // ✅ 출력 버퍼를 한 번에 비움 (속도 최적화)
        bw.close();
        br.close();
    }

    private static int findTree(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return Integer.MAX_VALUE;
        if (left <= start && end <= right) return tree[node];
        
        int mid = (start + end) / 2;
        return Math.min(findTree(node * 2, start, mid, left, right), 
                        findTree(node * 2 + 1, mid + 1, end, left, right));
    }

    private static int makeTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return tree[node];
        }
        
        int mid = (start + end) / 2;
        tree[node] = Math.min(makeTree(node * 2, start, mid), 
                              makeTree(node * 2 + 1, mid + 1, end));
        return tree[node];
    }
}
