

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int repeat = 0; repeat < input; repeat++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            System.out.println(bfs(num, target));
        }
    }

    private static String bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, String> path = new HashMap<>(); // 각 숫자의 최적 경로 저장
        Set<Integer> visited = new HashSet<>(); // 방문 여부 체크

        queue.add(start);
        path.put(start, "");
        visited.add(start);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            String str = path.get(num);

            if (num == target) return str;

            // 4가지 명령 수행
            int[] nextNums = {D(num), S(num), L(num), R(num)};
            char[] commands = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int newNum = nextNums[i];

                if (!visited.contains(newNum)) {
                    visited.add(newNum);
                    path.put(newNum, str + commands[i]);
                    queue.add(newNum);
                }
            }
        }

        return "";
    }

    private static int D(int num) {
        return (num * 2) % 10000;
    }

    private static int S(int num) {
        return num == 0 ? 9999 : num - 1;
    }

    private static int L(int num) {
        return (num % 1000) * 10 + (num / 1000);
    }

    private static int R(int num) {
        return (num % 10) * 1000 + (num / 10);
    }
}
