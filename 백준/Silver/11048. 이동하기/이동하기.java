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
        int[][] dp = new int[column][row];
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                int now = map[i][j];
                // 왼쪽, 위, 왼쪽 위에서 가져와야 함
                // 왼쪽 벽에 붙어있을 때
                if(j == 0){
                    if(i==0){
                        dp[i][j] = now;
                    }
                    else{
                        dp[i][j] = now + dp[i-1][j];
                    }
                }
                else if(i==0){
                    dp[i][j] = now + dp[i][j-1];
                }
                else{
                    dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + now;

                }
            }
        }
        System.out.println(dp[column-1][row-1]);
    }
}
