import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        long[][] number = new long[input][10];

        for(int i=0;i<10;i++) number[0][i] = 1;

        for(int i=1;i<input;i++){
            for(int j=0;j<10;j++){
                long sum = 0;
                for(int k=0;k<=j;k++){
                    sum += number[i-1][k];
                    sum %= 10007;
                }
                number[i][j] = sum;
            }
        }

        long answer = 0;
        for(int i=0;i<10;i++){
            answer += number[input-1][i];
        }
        System.out.println(answer % 10007);
    }
}