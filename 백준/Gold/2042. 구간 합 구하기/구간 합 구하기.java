import java.io.*;
import java.util.*;

public class Main {
    static long[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경 횟수
        int S = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수
        tree = new long[N * 4];
        arr = new long[N + 1];

        // 배열 입력 받기
        for (int i = 1; i <= N; i++) {
            String input = br.readLine().trim();
            if (input.isEmpty()) {
                arr[i] = 0; // 빈 입력이면 0으로 초기화
            } else {
                arr[i] = Long.parseLong(input);
            }
        }

        // 세그먼트 트리 초기화
        buildTree(1, 1, N);

        // 연산 처리
        for (int i = 0; i < M + S; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            if (st2.countTokens() < 3) { // 토큰 개수 확인
                System.err.println("잘못된 입력값이 들어왔습니다.");
                continue;
            }

            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            long c = Long.parseLong(st2.nextToken());

            if (a == 1) { // 값 변경
                if (b < 1 || b > N) {
                    System.err.println("잘못된 인덱스: " + b);
                } else {
                    arr[b] = c;
                    updateTree(1, 1, N, b, c);
                }
            } else if (a == 2) { // 구간 합 조회
                long result = query(1, 1, N, b, (int) c);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static long buildTree(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        tree[node] = buildTree(node * 2, start, mid) + buildTree(node * 2 + 1, mid + 1, end);
        return tree[node];
    }

    private static void updateTree(int node, int start, int end, int index, long newValue) {
        if (index < start || index > end) return;

        if (start == end) {
            arr[index] = newValue;
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        updateTree(node * 2, start, mid, index, newValue);
        updateTree(node * 2 + 1, mid + 1, end, index, newValue);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) return 0;
        if (L <= start && end <= R) return tree[node];

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, L, R) + query(node * 2 + 1, mid + 1, end, L, R);
    }
}
