
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        long temp1 = Integer.parseInt(br.readLine());
        long answer = temp1*3+1+temp1-1;
        // 위 = 1
        // 옆 = temp1 * 2
        // 아래 = temp1
        System.out.print(answer);
    }
}