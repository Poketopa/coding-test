import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] ans; // 각 컴퓨터별 해킹 가능 마릿수 저장
    static int[] visited; // int형으로 선언하여 매번 new 생성 방지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a); // B를 해킹하면 A가 해킹됨
        }

        ans = new int[N + 1];
        visited = new int[N + 1];
        int maxVal = 0;

        for (int i = 1; i <= N; i++) {
            ans[i] = bfs(i);
            maxVal = Math.max(maxVal, ans[i]);
        }

        // 결과 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (ans[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static int bfs(int start) {
        // ArrayDeque가 LinkedList보다 압도적으로 빠름
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        // visited 배열을 i값으로 체크하여 매번 초기화하는 시간을 아낌
        visited[start] = start;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int next : list[cur]) {
                if (visited[next] != start) { // 이번 루프(start)에서 방문했는지 확인
                    visited[next] = start;
                    q.add(next);
                }
            }
        }
        return count;
    }
}
