import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] number = new int[row][column];
        for(int i=0;i<row;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                number[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            int sum = 0;
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st2.nextToken())-1;
            int x1 = Integer.parseInt(st2.nextToken())-1;
            int y2 = Integer.parseInt(st2.nextToken())-1;
            int x2 = Integer.parseInt(st2.nextToken())-1;
            for(int j=Math.min(y1, y2);j<=Math.max(y1, y2);j++){
                for(int k=Math.min(x1, x2);k<=Math.max(x1, x2);k++){
                    sum += number[j][k];
                }
            }
            System.out.println(sum);
        }
    }
}






