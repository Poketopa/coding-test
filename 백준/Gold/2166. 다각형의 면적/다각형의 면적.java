
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        long[][] number = new long[input + 1][2];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            number[i][0] = Long.parseLong(st.nextToken());
            number[i][1] = Long.parseLong(st.nextToken());
        }
        number[input][0] = number[0][0];
        number[input][1] = number[0][1];
        long num1 = 0;
        long num2 = 0;
        for(int i=1;i<input + 1;i++){
            num1 += number[i][1] * number[i-1][0];
            num2 += number[i][0] * number[i-1][1];
        }
        double area = (double) Math.abs(num1 - num2) / 2;
        System.out.printf("%.1f", area);
    }
}
