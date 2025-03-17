

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        // 그래프 인접 리스트 생성
        List<Integer>[] list = new List[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // 서브트리 노드 개수 저장 배열 및 방문 배열
        int[] node = new int[N + 1];
        int[] visited = new int[N + 1];

        // 서브트리 크기 계산
        count(root, node, visited, list);

        // 쿼리 처리
        for (int i = 0; i < query; i++) {
            bw.write(node[Integer.parseInt(br.readLine())] + "\n");
        }

        // 출력 후 flush & close
        bw.flush();
        bw.close();
    }

    private static int count(int root, int[] node, int[] visited, List<Integer>[] list) {
        visited[root] = 1;
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < list[root].size(); i++) {
            if (visited[list[root].get(i)] == 1) continue;
            else {
                flag = true;
                count += count(list[root].get(i), node, visited, list);
            }
        }

        if (count == 0) {
            node[root] = 1;
            return 1;
        } else {
            node[root] = count + 1;
            return count + 1;
        }
    }
}
