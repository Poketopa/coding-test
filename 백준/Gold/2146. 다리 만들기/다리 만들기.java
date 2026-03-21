import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();

        int count = 1;

        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(map[i][j] == 1){
                    count++;
                    queue.add(new int[]{i, j});
                    map[i][j] = count;

                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0 <= newY && newY < input
                                    && 0 <= newX && newX < input
                                    && map[newY][newX] == 1){
                                map[newY][newX] = count;
                                queue.add(new int[]{newY, newX});
                            }
                        }
                    }
                }
            }
        }

        // 테두리 검사
        int min = Integer.MAX_VALUE;

        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(map[i][j] > 1){
                    queue.clear();
                    int[][] visited = new int[input][input];
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 1;

                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        if(map[temp[0]][temp[1]] != 0 && map[temp[0]][temp[1]] != map[i][j]){
                            min = Math.min(min, temp[2]);
                            break;
                        }
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0 <= newY && newY < input
                            && 0 <= newX && newX < input
                            && map[newY][newX] != map[i][j]
                            && visited[newY][newX] == 0){
                                visited[newY][newX] = 1;
                                queue.add(new int[]{newY, newX, temp[2] + 1});
                            }
                        }
                    }
                }
            }
        }
        System.out.print(min-1);
    }
}
