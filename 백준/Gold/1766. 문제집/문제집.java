
import java.io.*;
import java.util.*;

public class Main {
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[node + 1];
        degree = new int[node + 1];

        // 리스트 초기화
        for (int i = 0; i < list.length; i++) list[i] = new ArrayList<>();

        // 간선 정보 입력
        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            degree[b]++;
        }

        // 우선순위 큐 사용 (작은 숫자 우선)
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        // 진입 차수 0인 노드 큐에 삽입
        for (int i = 1; i <= node; i++) {
            if (degree[i] == 0) queue.add(i);
        }

        // 위상 정렬 실행
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            bw.write(temp + " "); // BufferedWriter 사용하여 출력

            for (int i = 0; i < list[temp].size(); i++) {
                degree[list[temp].get(i)]--;
                if (degree[list[temp].get(i)] == 0) queue.add(list[temp].get(i));
            }
        }

        // 출력 후 flush & close
        bw.flush();
        bw.close();
    }
}
