import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        for(int i=0;i<column;i++){
            String input = br.readLine();
            for(int j=0;j<row;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int[][] visited = new int[column][row];
        int[][] breakVisited = new int[column][row];
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        // y좌표, x좌표, 깬 벽 수, 카운터
        queue.add(new int[]{0, 0, 0, 1});
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int breakWallCount = temp[2];
            if(breakWallCount > 1) continue;
            if(temp[0] == column-1 && temp[1] == row -1){
                min = Math.min(min, temp[3]);
            }
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                if(0 <= newY && newY < column
                && 0 <= newX && newX < row) {
                    if(breakWallCount == 1 && breakVisited[newY][newX] == 0){
                        // 벽 안 부수는 경우
                        if(map[newY][newX] == 0){
                            queue.add(new int[]{newY, newX, breakWallCount, temp[3] + 1});
                            breakVisited[newY][newX] = 1;
                        }
                    }
                    if(breakWallCount == 0 && visited[newY][newX] == 0){
                        // 벽 안 부수는 경우
                        if(map[newY][newX] == 0){
                            queue.add(new int[]{newY, newX, breakWallCount, temp[3] + 1});
                            visited[newY][newX] = 1;
                        }
                        // 벽 부수는 경우
                        else if(map[newY][newX] == 1 && temp[2] == 0){
                            queue.add(new int[]{newY, newX, breakWallCount + 1, temp[3] + 1});
                            breakVisited[newY][newX] = 1;
                        }
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }
}
