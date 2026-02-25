import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        int sum = 2 * (row * column);
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(j == 0) {
                    sum += map[i][j];
                    continue;
                }
                if(map[i][j] - map[i][j-1] > 0){
                    sum += map[i][j] - map[i][j-1];
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(j == 0) {
                    sum += map[row - 1 - i][column - 1 - j];
                    continue;
                }
                if(map[row - 1 - i][column - 1 - j] - map[row - 1 - i][column - j] > 0){
                    sum += map[row - 1 - i][column - 1 - j] - map[row - 1 - i][column - j];
                }
            }
        }

        for(int j=0;j<column;j++){
            for(int i=0;i<row;i++){
                if(i == 0) {
                    sum += map[i][j];
                    continue;
                }
                if(map[i][j] - map[i - 1][j] > 0){
                    sum += map[i][j] - map[i - 1][j];
                }
            }
        }

        for(int j=0;j<column;j++){
            for(int i=0;i<row;i++){
                if(i == 0) {
                    sum += map[row - 1 - i][column - 1 - j];
                    continue;
                }
                if(map[row - 1 - i][column - 1 - j] - map[row - i][column - 1 - j] > 0){
                    sum += map[row - 1 - i][column - 1 - j] - map[row - i][column - 1 - j];
                }
            }
        }


        System.out.print(sum);
    }
}
