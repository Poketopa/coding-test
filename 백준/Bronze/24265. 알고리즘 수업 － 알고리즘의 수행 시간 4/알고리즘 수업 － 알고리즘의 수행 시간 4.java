
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        long input = Integer.parseInt(br.readLine());
        long sum = 0;
        for(long i=input-1;i>=0;i--) sum+=i;
        System.out.println(sum);
        System.out.println("2");

    }
}