import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] visited = new int[N][N];
        for(int i=0;i<visited.length;i++) Arrays.fill(visited[i], -1);
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        queue.add(new int[]{0, 0, 0}); // y, x, 벽 부순 횟수
        visited[0][0] = 0;


        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == N-1 && temp[1] == N-1){
                System.out.print(temp[2]);
                return;
            }

            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                if(0 <= newY && newY < N
                && 0 <= newX && newX < N){
                    if(map[newY][newX] == 1 && (visited[newY][newX] == -1 || visited[newY][newX] > temp[2])){
                        queue.add(new int[]{newY, newX, temp[2]});
                        visited[newY][newX] = temp[2];
                    }
                    else if(map[newY][newX] == 0 && (visited[newY][newX] == -1 || visited[newY][newX] - 1 > temp[2])){
                        queue.add(new int[]{newY, newX, temp[2] + 1});
                        visited[newY][newX] = temp[2] + 1;
                    }
                    }
                }
        }
    }
}






