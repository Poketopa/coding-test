import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][column];
        for(int i=0;i<row;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};

        int maxLength = -1;
        int maxValue = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == 0) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j, 0, map[i][j]});
                int[][] visited = new int[row][column];
                visited[i][j] = 1;

                while(!queue.isEmpty()){
                    int[] temp = queue.poll();
                    if (temp[2] > maxLength) {
                        maxLength = temp[2];
                        maxValue = temp[3] + map[temp[0]][temp[1]];
                    } else if (temp[2] == maxLength) {
                        maxValue = Math.max(maxValue, temp[3] + map[temp[0]][temp[1]]);
                    }
                    for(int k=0;k<4;k++){
                        int newY = temp[0] + y[k];
                        int newX = temp[1] + x[k];
                        if(0 <= newY && newY < row
                        && 0 <= newX && newX < column
                        && visited[newY][newX] == 0
                        && map[newY][newX] != 0){
                            queue.add(new int[]{newY, newX, temp[2] + 1, temp[3]});
                            visited[newY][newX] = 1;
                        }
                    }
                }
            }
        }

        System.out.print(maxValue);
    }
}
