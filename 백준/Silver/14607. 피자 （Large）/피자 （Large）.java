import java.io.*;
import java.util.*;

public class Main {
    static long pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        long input = Integer.parseInt(br.readLine());
        pizza(input);
        System.out.println(pleasure);
    }

    public static void pizza(long input){
        if(input == 1) return;
        long half = input / 2;
        long another = input - half;
        pleasure += half * another;
        pizza(half);
        pizza(another);
    }
}
