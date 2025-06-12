import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        long[][] number = new long[(int) input][10];
        for(int i=1;i<10;i++) number[0][i] = 1;

        for(int i=1;i<input;i++){
            for(int j=0;j<10;j++){
                if(j == 0){
                    number[i][j] = number[i-1][1];
                }
                else if(j == 9){
                    number[i][j] = number[i-1][8];
                }
                else{
                    number[i][j] = number[i-1][j-1] + number[i-1][j+1];
                }
                number[i][j] %= 1000000000;
            }
        }

        long sum = 0;

        for(int i=0;i<10;i++){
            sum += number[input-1][i];
            sum %= 1000000000;
        }

        System.out.println(sum);
    }
}