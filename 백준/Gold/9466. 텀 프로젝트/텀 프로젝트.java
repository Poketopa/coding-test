import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count; // 팀을 이룬 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }
            // 전체 학생 수 - 팀에 속한 학생 수
            System.out.println(n - count);
        }
    }

    public static void dfs(int now) {
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            // 방문은 했으나 탐색이 끝나지 않았다면 사이클 발견!
            if (!finished[next]) {
                // 사이클에 포함된 노드 개수를 직접 카운트
                count++; 
                for (int temp = next; temp != now; temp = arr[temp]) {
                    count++;
                }
            }
        }

        // 탐색이 끝났음을 표시 (사이클 여부와 상관없이 방문 완료)
        finished[now] = true;
    }
}