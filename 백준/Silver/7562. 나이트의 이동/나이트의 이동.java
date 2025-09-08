import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(br.readLine());
        int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] x = {-2, -1, 1 ,2, -2, -1, 1, 2};
        for(int i=0;i<testCase;i++){
            int input = Integer.parseInt(br.readLine());
            int[][] map = new int[input][input];
            int[] now = new int[2];
            int[] target = new int[2];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                now[j] = Integer.parseInt(st1.nextToken());
                target[j] = Integer.parseInt(st2.nextToken());
            }
            int[][] visited = new int[input][input];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{now[0], now[1], 0});
            visited[now[0]][now[1]] = 1;
            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                if(temp[0] == target[0] && temp[1] == target[1]){
                    System.out.println(temp[2]);
                    break;
                }
                for(int j=0;j<8;j++){
                    int newY = temp[0] + y[j];
                    int newX = temp[1] + x[j];
                    if(0 <= newY && newY < input
                    && 0 <= newX && newX < input
                    && visited[newY][newX] == 0){
                        queue.add(new int[]{newY, newX, temp[2] + 1});
                        visited[newY][newX] = 1;
                    }
                }
            }
        }
    }
}
