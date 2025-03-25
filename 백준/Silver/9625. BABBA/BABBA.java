
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int prev = 1;
        int a = 1;
        int b = 0;
        for(int i=0;i<input;i++){
            prev = a + b;
            a = b;
            b = prev;
        }
        System.out.println(a+" "+b);
    }
}