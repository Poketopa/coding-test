import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());
        int c = Integer.valueOf(br.readLine());
        String temp = String.valueOf(a) + String.valueOf(b);
        System.out.println(a+b-c);
        System.out.println(Integer.valueOf(temp) - c);
    }
}
