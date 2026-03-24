import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int length = Integer.parseInt(st.nextToken());

        int[][] map = new int[row + 1][column + 1];
        for(int i=0;i<row;i++){
            String temp = br.readLine();
            for(int j=0;j<column;j++){
                if(temp.charAt(j) == 'B') {
                    map[i + 1][j + 1] = 0;
                } else {
                    map[i + 1][j + 1] = 1;
                }
            }
        }

        int[][] blackMap = new int[row+1][column+1];
        int[][] whiteMap = new int[row+1][column+1];

        boolean flag = false;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
                boolean isEven = ((i + j) % 2 == 0);
                if(isEven){
                    if(map[i][j] == 1) blackMap[i][j]++;
                    if(map[i][j] == 0) whiteMap[i][j]++;
                } else {
                    if(map[i][j] == 0) blackMap[i][j]++;
                    if(map[i][j] == 1) whiteMap[i][j]++;
                }
            }
        }

        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
                blackMap[i][j] += (blackMap[i-1][j] + blackMap[i][j-1] - blackMap[i-1][j-1]);
                whiteMap[i][j] += (whiteMap[i-1][j] + whiteMap[i][j-1] - whiteMap[i-1][j-1]);
            }
        }


        long min = Long.MAX_VALUE;

        for(int i=length;i<=row;i++){
            for(int j=length;j<=column;j++){
                min = Math.min(blackMap[i][j] - blackMap[i-length][j] - blackMap[i][j-length] + blackMap[i-length][j-length], min);
                min = Math.min(whiteMap[i][j] - whiteMap[i-length][j] - whiteMap[i][j-length] + whiteMap[i-length][j-length], min);
            }
        }

        System.out.print(min);
    }
}
