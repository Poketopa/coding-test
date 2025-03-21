
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
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<row;i++){
            int temp = Integer.parseInt(st2.nextToken());
            for(int k=0;k<temp;k++){
                map[k][i] = 1;
            }
        }
        long sum = 0;
        for(int i=0;i<column;i++){
            for(int j=1;j<row-1;j++){
                // 비어있으면 고일 수 있는지 확인
                if(map[i][j] == 0){
                    int left = j;
                    int right = j;
                    boolean leftFlag = false;
                    boolean rightFlag = false;
                    boolean outLeft = false;
                    boolean outRight = false;
                    while(true){
                        if(!outLeft) map[i][left] = 1;
                        if(!outRight) map[i][right] = 1;

                        if(!leftFlag) left--;
                        if(!rightFlag) right++;
                        if(left == -1) outLeft = true;
                        if(right == row) outRight = true;

                        if(!outLeft && map[i][left] == 1) leftFlag = true;
                        if(!outRight && map[i][right] == 1) rightFlag = true;
                        if((leftFlag && rightFlag) || (leftFlag && outRight) || (outLeft && rightFlag) || (outLeft && outRight)) break;

                    }
                    if(leftFlag && rightFlag) sum += right - left -1;
                }
            }
        }
        System.out.println(sum);
    }
}