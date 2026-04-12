import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[4];
        for(int i = 0; i < input; i++) num[i] = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[61][61][61];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(num);
        visited[num[0]][num[1]][num[2]] = true;

        int[][] damages = {
                {9, 3, 1}, {9, 1, 3}, {3, 9, 1},
                {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
        };

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            if(temp[0] == 0 && temp[1] == 0 && temp[2] == 0) {
                System.out.print(temp[3]);
                return;
            }

            for(int[] d : damages) {
                int n1 = Math.max(0, temp[0] - d[0]);
                int n2 = Math.max(0, temp[1] - d[1]);
                int n3 = Math.max(0, temp[2] - d[2]);

                if(!visited[n1][n2][n3]) {
                    visited[n1][n2][n3] = true;
                    queue.add(new int[]{n1, n2, n3, temp[3] + 1});
                }
            }
        }
    }
}
