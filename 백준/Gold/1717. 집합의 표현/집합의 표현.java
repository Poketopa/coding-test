
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        parent = new int[node + 1];

        // 부모 배열 초기화 (자기 자신을 부모로 설정)
        for (int i = 1; i <= node; i++) parent[i] = i;

        // 간선 처리
        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            if (a == 0) {
                // Union 연산
                union(find(b), find(c));
            } else {
                // Find 연산 및 결과 출력
                if (find(b) == find(c)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        // 출력 후 flush 및 close
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        else {
            parent[x] = find(parent[x]); // 경로 압축 (Path Compression)
            return parent[x];
        }
    }
}
