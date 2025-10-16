import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 바이러스의 개수

        int[][] map = new int[N][N];

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[3] == b[3]){
                return a[2] - b[2];
            } else return a[3] - b[3];
        });

        for(int i=0;i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j] != 0){
                    queue.add(new int[]{i, j, map[i][j], 1});
                    // y, x, 바이러스 값, 시간
                }
            }
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st3.nextToken()); // S초 뒤에 X, Y에 존재하는 바이러스의 종류
        int X = Integer.parseInt(st3.nextToken());
        int Y = Integer.parseInt(st3.nextToken());


        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[3] > S) continue;
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                if(0 <= newY && newY < N
                && 0 <= newX && newX < N
                && map[newY][newX] == 0){
                    map[newY][newX] = temp[2];
                    queue.add(new int[]{newY, newX, temp[2], temp[3] + 1});
                }
            }
        }

        System.out.print(map[X-1][Y-1]);
    }
}






