import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] answer = new long[input][input];
        answer[0][0] = 1;

        x:for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(i==input-1 && j==input-1) break x;
                int temp = map[i][j];
                if(i+temp < input){
                    answer[i+temp][j] += answer[i][j];
                }
                if(j+temp < input){
                    answer[i][j+temp] += answer[i][j];
                }
            }
        }
        System.out.print(answer[input-1][input-1]);
    }
}