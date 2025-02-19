
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[9][9];
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        int y = 0;
        int x = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(max < map[i][j]){
                    max = map[i][j];
                    y = i;
                    x = j;
                }

            }
        }
        System.out.println(max);
        System.out.println((y+1)+" "+ (x+1));




    }
}