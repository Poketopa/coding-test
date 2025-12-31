import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        for (int repeat = 0; repeat < input; repeat++) {
            char[] inputArray = new char[9];
            int count = 8;
            for (int j = 0; j < 3; j++) {
                String temp = br.readLine();
                for (int i = 0; i < 3; i++) {

                    inputArray[count] = temp.charAt(i);
                    count--;
                }
            }

            int target = 0;
            for (int i = 0; i < 9; i++) {
                if (inputArray[i] == '*') {
                    target += (int) Math.pow(2, i);
                }
            }

            int[] visited = new int[513];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0}); // 현재 숫자, 카운팅
            visited[0] = 1;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int nowNumber = temp[0];
                int counting = temp[1];
                if (nowNumber == target) {
                    System.out.println(counting);
                    break;
                }

                int next1 = nowNumber ^ 416;
                if (visited[next1] == 0) {
                    visited[next1] = 1;
                    queue.add(new int[]{next1, counting + 1});
                }
                
                int next2 = nowNumber ^ 464;
                if (visited[next2] == 0) {
                    visited[next2] = 1;
                    queue.add(new int[]{next2, counting + 1});
                }
                
                int next3 = nowNumber ^ 200;
                if (visited[next3] == 0) {
                    visited[next3] = 1;
                    queue.add(new int[]{next3, counting + 1});
                }
                
                int next4 = nowNumber ^ 308;
                if (visited[next4] == 0) {
                    visited[next4] = 1;
                    queue.add(new int[]{next4, counting + 1});
                }

                int next5 = nowNumber ^ 186;
                if (visited[next5] == 0) {
                    visited[next5] = 1;
                    queue.add(new int[]{next5, counting + 1});
                }

                int next6 = nowNumber ^ 89;
                if (visited[next6] == 0) {
                    visited[next6] = 1;
                    queue.add(new int[]{next6, counting + 1});
                }

                int next7 = nowNumber ^ 38;
                if (visited[next7] == 0) {
                    visited[next7] = 1;
                    queue.add(new int[]{next7, counting + 1});
                }

                int next8 = nowNumber ^ 23;
                if (visited[next8] == 0) {
                    visited[next8] = 1;
                    queue.add(new int[]{next8, counting + 1});
                }

                int next9 = nowNumber ^ 11;
                if (visited[next9] == 0) {
                    visited[next9] = 1;
                    queue.add(new int[]{next9, counting + 1});
                }
            }
        }
    }
}

