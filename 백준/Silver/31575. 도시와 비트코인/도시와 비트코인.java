import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        if(map[0][0] == 0) {
            System.out.println("No");
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[column][row];
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        int[] y = {0, 1};
        int[] x = {1 ,0};
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == column-1 && temp[1] == row-1){
                System.out.println("Yes");
                return;
            }
            for(int i=0;i<2;i++){
                int tempY = temp[0] + y[i];
                int tempX = temp[1] + x[i];
                if(0 <= tempY && tempY < column
                && 0 <= tempX && tempX < row
                && map[tempY][tempX] == 1
                && visited[tempY][tempX] == 0){
                    queue.add(new int[]{tempY, tempX});
                    visited[tempY][tempX] = 1;
                }
            }
        }
        System.out.println("No");
    }
}
