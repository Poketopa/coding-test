import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        long now = 1;
        long prev = 0;
        for(int i=1;i<=input;i++){
            long temp = now;
            now += prev;
            prev = temp;
            now %= 10007;
            prev %= 10007;
        }
        System.out.println(now % 10007);
    }
}