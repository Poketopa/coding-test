
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        for (int l = 0; l < input; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] node = new int[N + 1];
            int[] sumNode = new int[N + 1];
            int[] startNode = new int[N + 1]; // 출발하는 노드인지 확인
            List<Integer>[] list = new List[N + 1];

            for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

            // 노드 값 입력
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) node[i] = Integer.parseInt(st2.nextToken());

            // 간선 입력
            for (int i = 0; i < M; i++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st3.nextToken());
                int b = Integer.parseInt(st3.nextToken());
                list[a].add(b);
                startNode[b] = 1;
            }

            // 위상 정렬을 위한 큐
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (startNode[i] == 0) queue.add(i);
            }

            // 위상 정렬 실행
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                for (int i = 0; i < list[temp].size(); i++) {
                    if (sumNode[list[temp].get(i)] < sumNode[temp] + node[temp]) {
                        sumNode[list[temp].get(i)] = sumNode[temp] + node[temp];
                        queue.add(list[temp].get(i));
                    }
                }
            }

            int W = Integer.parseInt(br.readLine());
            bw.write((sumNode[W] + node[W]) + "\n");
        }

        // 출력 후 flush & close
        bw.flush();
        bw.close();
    }
}
