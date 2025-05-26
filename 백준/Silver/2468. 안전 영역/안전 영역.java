import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        int maxHeight = -1;
        int minHeight = 101;
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        for(int height = minHeight-1;height <= maxHeight; height++){
            Queue<int[]> queue = new LinkedList<>();
            int[][] visited = new int[input][input];
            int count = 0;
            for(int i=0;i<input;i++){
                for(int j=0;j<input;j++){
                    if(map[i][j] > height && visited[i][j] == 0){// 높이 낮은 곳 발견
                        queue.add(new int[]{i, j});
                        visited[i][j] = 1;
                        count++;
                        while(!queue.isEmpty()){
                            int[] temp = queue.poll();
                            for(int k=0;k<4;k++){
                                int newY = temp[0] + y[k];
                                int newX = temp[1] + x[k];
                                if(0 <= newY && newY < input
                                && 0 <= newX && newX < input
                                && visited[newY][newX] == 0
                                && map[newY][newX] > height){
                                    queue.add(new int[]{newY, newX});
                                    visited[newY][newX] = 1;
                                }
                            }
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
