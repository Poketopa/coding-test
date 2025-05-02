import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        int[][] visited = new int[column][row];
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st2.nextToken())-1][Integer.parseInt(st2.nextToken())-1] = 1;
        }
        int max = -1;
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(map[i][j] == 1){
                    int count = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        count++;
                        map[temp[0]][temp[1]] = 2;
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0 <= newY && newY < column
                            && 0 <= newX && newX < row
                            && map[newY][newX] == 1
                            && visited[newY][newX] == 0){
                                queue.add(new int[]{newY, newX});
                                visited[newY][newX] = 1;
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }
}
