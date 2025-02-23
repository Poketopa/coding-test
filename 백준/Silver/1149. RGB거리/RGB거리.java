
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] house = new int[input][3];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dp = new int[input];
        int prev = 0;

        // 길이가 1일 때
        if(input == 1){
            System.out.println(Math.min(Math.min(house[0][0], house[0][1]), house[0][2]));
            return;
        }
        // 길이가 2일 때
        for(int i=1;i<input;i++){
            house[i][0] = Math.min(house[i-1][1] + house[i][0], house[i-1][2] + house[i][0]);
            house[i][1] = Math.min(house[i-1][0] + house[i][1], house[i-1][2] + house[i][1]);
            house[i][2] = Math.min(house[i-1][0] + house[i][2], house[i-1][1] + house[i][2]);
        }

        int answer = 0;
        answer = Math.min(Math.min(house[input-1][0], house[input-1][1]), house[input-1][2]);
        System.out.println(answer);
    }
}