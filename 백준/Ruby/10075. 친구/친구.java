import java.io.InputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        if (n == -1) return;

        // 신뢰도의 합은 int 범위를 초과할 수 있으므로 long 타입 사용
        long[] v0 = new long[n];
        long[] v1 = new long[n];

        for (int i = 0; i < n; i++) {
            v1[i] = sc.nextInt();
        }

        int[] host = new int[n];
        int[] prot = new int[n];
        for (int i = 1; i < n; i++) {
            host[i] = sc.nextInt();
            prot[i] = sc.nextInt();
        }

        // 역순으로 서브그래프들을 병합
        for (int i = n - 1; i > 0; i--) {
            int h = host[i];
            int p = prot[i];

            long v0_h = v0[h];
            long v1_h = v1[h];
            long v0_i = v0[i];
            long v1_i = v1[i];

            if (p == 0) { // IAmYourFriend
                v0[h] = v0_h + Math.max(v0_i, v1_i);
                v1[h] = v1_h + v0_i;
            } else if (p == 1) { // MyFriendsAreYourFriends
                v0[h] = v0_h + v0_i;
                v1[h] = Math.max(v1_h + v0_i, Math.max(v0_h + v1_i, v1_h + v1_i));
            } else if (p == 2) { // WeAreYourFriends
                v0[h] = v0_h + v0_i;
                v1[h] = Math.max(v1_h + v0_i, v0_h + v1_i);
            }
        }

        // 루트 노드(0)에서 최댓값 출력
        System.out.println(Math.max(v0[0], v1[0]));
    }

    // 메모리 초과(16MB) 방지를 위한 커스텀 스캐너
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1 << 13]; // 8KB Buffer
        private int head, tail;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = stream.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public int nextInt() throws IOException {
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