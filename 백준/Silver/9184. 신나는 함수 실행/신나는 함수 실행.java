
import java.io.*;
import java.util.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[][][] number = new int[20 + 1][20 + 1][20 + 1];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break;

            System.out.println("w("+a+", "+b+", "+c+") = " + change(a, b, c, number));
        }
    }
    private static int change(int a, int b, int c, int[][][] number){
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) return number[20][20][20] = change(20, 20, 20, number);
        if(number[a][b][c] != 0) return number[a][b][c];
        if(a < b && b < c) {
            return number[a][b][c] = (change(a, b, c-1, number) + change(a, b-1, c-1, number) - change(a, b-1, c, number));
        }
        else {
            return number[a][b][c] = (change(a-1, b, c, number) + change(a-1, b-1, c, number) + change(a-1, b, c-1, number) - change(a-1, b-1, c-1, number));
        }
    }
}