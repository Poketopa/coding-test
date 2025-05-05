import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int count = 0;
        int max = 0;
        int[] y = {1,-1, 0, 0};
        int[] x = {0, 0, 1, -1};
        int[][] visited = new int[column][row];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(map[i][j] == 1){
                    count++;
                    int tempCount = 0;
                    queue.add(new int[]{i, j});
                    map[i][j] = 0;
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        tempCount++;
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0 <= newY && newY < column
                            && 0 <= newX && newX < row
                            && map[newY][newX] == 1){
                                queue.add(new int[]{newY, newX});
                                map[newY][newX] = 0;
                            }
                        }

                    }
                    max = Math.max(tempCount, max);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
