import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int wall = Integer.parseInt(st.nextToken());
        // 세로, 가로, 부신 벽 몇개?
        int[][] map = new int[row][column];
        int[][][] visited = new int[row][column][wall + 1];
        for(int i=0;i<row;i++){
            String input = br.readLine();
            String[] arr = input.split("");
            for(int j=0;j<column;j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        // 세로, 가로, 벽, 이동 횟수
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = 1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == map.length-1 && temp[1] == map[0].length-1){
                System.out.println(temp[3] + 1);
                return;
            }
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                int wallCount = temp[2];
                int move = temp[3];
                if(0 <= newY && newY < map.length
                && 0 <= newX && newX < map[0].length){
                    if(map[newY][newX] == 1) wallCount++;
                    if(wallCount > wall) continue;
                    if(visited[newY][newX][wallCount] == 0) {
                        visited[newY][newX][wallCount] = 1;
                        queue.add(new int[]{newY, newX, wallCount, move + 1});
                    }
                }
            }
        }
        System.out.println("-1");
    }
}