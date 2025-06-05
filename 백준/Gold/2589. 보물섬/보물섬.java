import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][column];
        for(int i=0;i<row;i++){
            String temp = br.readLine();
            for(int j=0;j<column;j++){
                if(temp.charAt(j) == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        int answer = -1;

        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == 1) {
                    int max = -1;
                    int[][] visited = new int[row][column];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 1;

                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0 <= newY && newY < row
                            && 0 <= newX && newX < column
                            && visited[newY][newX] == 0
                            && map[newY][newX] == 1){
                                queue.add(new int[]{newY, newX, temp[2] + 1});
                                visited[newY][newX] = 1;
                                answer = Math.max(answer, temp[2] + 1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}