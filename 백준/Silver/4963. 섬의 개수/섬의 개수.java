import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] y = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] x = {1, -1, 0, 0, 1, -1, 1, -1};
        Queue<int[]> queue = new LinkedList<>();


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            if(row == 0 && column == 0) return;
            int[][] map = new int[column][row];
            int[][] visited = new int[column][row];
            for(int i=0;i<column;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j = 0; j< row; j++){
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            // bfs 시작
            int count = 0;
            for(int i=0;i<column;i++){
                for(int j = 0; j< row; j++){
                    if(map[i][j] == 1){
                        count++;
                        queue.add(new int[]{i,j});
                        visited[i][j] = 1;
                        map[i][j] = 2;
                        while(!queue.isEmpty()){
                            int[] temp = queue.poll();
                            for(int k=0;k<8;k++){
                                int newY = temp[0] + y[k];
                                int newX = temp[1] + x[k];
                                if(0 <= newY && newY < map.length
                                        && 0 <= newX && newX < map[0].length
                                        && map[newY][newX] == 1
                                        && visited[newY][newX] == 0){
                                    queue.add(new int[]{newY, newX});
                                    visited[newY][newX] = 1;
                                    map[newY][newX] = 2;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }


    }
}