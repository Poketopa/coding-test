import java.io.*;
import java.util.*;

public class Main {
    static int pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][][] map = new int[3][row][column];
        for(int i=0;i<row;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                int temp = Integer.parseInt(st2.nextToken());
                map[0][i][j] = temp;
                map[1][i][j] = temp;
                map[2][i][j] = temp;
            }
        }
        for(int i=1;i<row;i++){
            // 0: 오른쪽에서 옴
            // 1: 가운데에서 옴
            // 2: 왼쪽에서 옴
            for(int j=0;j<column;j++){
                if(j == column - 1) map[0][i][j] = Integer.MAX_VALUE;
                if(j == 0) map[2][i][j] = Integer.MAX_VALUE;
                if(j < column - 1){
                    map[0][i][j] += Math.min(map[1][i-1][j+1], map[2][i-1][j+1]);
                }
                map[1][i][j] += Math.min(map[0][i-1][j], map[2][i-1][j]);
                if(j > 0){
                    map[2][i][j] += Math.min(map[0][i-1][j-1], map[1][i-1][j-1]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<column;j++){
                answer = Math.min(answer, map[i][row-1][j]);
            }
        }
        System.out.println(answer);
    }
}