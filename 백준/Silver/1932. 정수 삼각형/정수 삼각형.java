
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=input-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                map[i][j] = Math.max(map[i][j]+map[i+1][j], map[i][j] + map[i+1][j+1]);
            }
        }
        System.out.println(map[0][0]);
    }
}