import java.io.InputStream;

public class Main {
    static final int FULL = (1 << 20) - 1;
    static int[] max_val;
    static int[] and_val;
    static int[] or_val;
    static int[] lazy_and;
    static int[] lazy_or;
    static int[] A;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int N = sc.nextInt();
        if (N == -1) return;
        
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        
        // 트리 배열 초기화 (넉넉하게 4N)
        int size = 4 * N + 1;
        max_val = new int[size];
        and_val = new int[size];
        or_val  = new int[size];
        lazy_and = new int[size];
        lazy_or  = new int[size];
        
        build(1, 1, N);
        
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                int X = sc.nextInt();
                update_and(1, 1, N, L, R, X);
            } else if (type == 2) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                int X = sc.nextInt();
                update_or(1, 1, N, L, R, X);
            } else if (type == 3) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                sb.append(query(1, 1, N, L, R)).append('\n');
            }
        }
        System.out.print(sb);
    }
    
    // 구간에 Lazy Tag 적용
    static void apply(int node, int a, int b) {
        max_val[node] = (max_val[node] & a) | b;
        and_val[node] = (and_val[node] & a) | b;
        or_val[node]  = (or_val[node] & a) | b;
        lazy_and[node] = lazy_and[node] & a;
        lazy_or[node]  = (lazy_or[node] & a) | b;
    }
    
    // 자식 노드의 값들을 모아 부모 노드 갱신
    static void pull(int node) {
        int lc = node * 2;
        int rc = node * 2 + 1;
        max_val[node] = Math.max(max_val[lc], max_val[rc]);
        and_val[node] = and_val[lc] & and_val[rc];
        or_val[node]  = or_val[lc] | or_val[rc];
    }
    
    // 자식 노드로 Lazy Tag 전파
    static void push(int node) {
        if (lazy_and[node] != FULL || lazy_or[node] != 0) {
            apply(node * 2, lazy_and[node], lazy_or[node]);
            apply(node * 2 + 1, lazy_and[node], lazy_or[node]);
            lazy_and[node] = FULL;
            lazy_or[node] = 0;
        }
    }
    
    // 세그먼트 트리 초기 구성
    static void build(int node, int L, int R) {
        lazy_and[node] = FULL;
        lazy_or[node] = 0;
        if (L == R) {
            max_val[node] = A[L];
            and_val[node] = A[L];
            or_val[node]  = A[L];
            return;
        }
        int mid = (L + R) / 2;
        build(node * 2, L, mid);
        build(node * 2 + 1, mid + 1, R);
        pull(node);
    }
    
    // 1번 쿼리: 구간 AND 연산
    static void update_and(int node, int L, int R, int qL, int qR, int X) {
        if (qR < L || R < qL) return;
        if (qL <= L && R <= qR) {
            // 변경되는 비트들 중 끄려는 비트(~X)가 자식들 간에 차이가 없는 경우
            int diff = and_val[node] ^ or_val[node];
            if ((diff & ~X) == 0) {
                apply(node, X, 0);
                return;
            }
        }
        push(node);
        int mid = (L + R) / 2;
        update_and(node * 2, L, mid, qL, qR, X);
        update_and(node * 2 + 1, mid + 1, R, qL, qR, X);
        pull(node);
    }
    
    // 2번 쿼리: 구간 OR 연산
    static void update_or(int node, int L, int R, int qL, int qR, int X) {
        if (qR < L || R < qL) return;
        if (qL <= L && R <= qR) {
            // 변경되는 비트들 중 켜려는 비트(X)가 자식들 간에 차이가 없는 경우
            int diff = and_val[node] ^ or_val[node];
            if ((diff & X) == 0) {
                apply(node, FULL, X);
                return;
            }
        }
        push(node);
        int mid = (L + R) / 2;
        update_or(node * 2, L, mid, qL, qR, X);
        update_or(node * 2 + 1, mid + 1, R, qL, qR, X);
        pull(node);
    }
    
    // 3번 쿼리: 구간 최댓값 출력
    static int query(int node, int L, int R, int qL, int qR) {
        if (qR < L || R < qL) return 0;
        if (qL <= L && R <= qR) return max_val[node];
        push(node);
        int mid = (L + R) / 2;
        return Math.max(query(node * 2, L, mid, qL, qR),
                        query(node * 2 + 1, mid + 1, R, qL, qR));
    }
    
    // 빠른 입력을 위한 FastScanner 클래스
    static class FastScanner {
        private InputStream in;
        private byte[] buffer = new byte[65536];
        private int head = 0;
        private int tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (Exception e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }
}