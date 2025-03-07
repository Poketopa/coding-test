
import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] number = new int[input][3];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            number[i][0] = Integer.parseInt(st.nextToken());
            number[i][1] = Integer.parseInt(st.nextToken());
            number[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] max = new int[input][3];
        int[][] min = new int[input][3];
        for(int i=0;i<input;i++){
            max[i][0] = number[i][0];
            min[i][0] = number[i][0];
            max[i][1] = number[i][1];
            min[i][1] = number[i][1];
            max[i][2] = number[i][2];
            min[i][2] = number[i][2];
        }
        // 크기가 1일 때 예외
        for(int i=1;i<input;i++){
            max[i][0] = Math.max(max[i-1][0] + max[i][0], max[i-1][1] + max[i][0]);
            min[i][0] = Math.min(min[i-1][0] + min[i][0], min[i-1][1] + min[i][0]);
            max[i][1] = Math.max(Math.max(max[i-1][0] + max[i][1], max[i-1][1] + max[i][1]), max[i-1][2] + max[i][1]);
            min[i][1] = Math.min(Math.min(min[i-1][0] + min[i][1], min[i-1][1] + min[i][1]), min[i-1][2] + min[i][1]);
            max[i][2] = Math.max(max[i-1][2] + max[i][2], max[i-1][1] + max[i][2]);
            min[i][2] = Math.min(min[i-1][2] + min[i][2], min[i-1][1] + min[i][2]);
        }
        int answerMax = Math.max(Math.max(max[input-1][0], max[input-1][1]), max[input-1][2]);
        int answerMin = Math.min(Math.min(min[input-1][0], min[input-1][1]), min[input-1][2]);
        System.out.print(answerMax + " " + answerMin);
    }
}
