
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        for(int k=0;k<2;k++){
            for(int i=0;i<column;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j=0;j<row;j++){
                    map[i][j] += Integer.parseInt(st2.nextToken());
                }
            }
        }
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
    }
}