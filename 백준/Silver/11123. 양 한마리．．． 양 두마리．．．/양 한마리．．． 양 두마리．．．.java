import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] y  = new int[]{-1, 1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        int input = Integer.parseInt(br.readLine());
        for(int repeat = 0;repeat < input;repeat++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int count = 0;
            int[][] map = new int[row][column];
            for(int i=0;i<row;i++){
                String temp = br.readLine();
                for(int j=0;j<column;j++){
                    if(temp.charAt(j) == '.') map[i][j] = 0;
                    else map[i][j] = 1;
                }
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(map[i][j] == 1){
                        count++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        map[i][j] = 0;
                        while(!queue.isEmpty()){
                            int[] temp = queue.poll();
                            for(int k=0;k<4;k++){
                                int newY = temp[0] + y[k];
                                int newX = temp[1] + x[k];
                                if(0 <= newY && newY < row
                                && 0 <= newX && newX < column
                                && map[newY][newX] == 1){
                                    queue.add(new int[]{newY, newX});
                                    map[newY][newX] = 0;
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
