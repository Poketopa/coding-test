
import java.io.*;
import java.util.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        fib(input);
        if(input <=2) System.out.println(count1 + " " + 1);
        else System.out.println(count1 + " " + (input-2));
    }
    private static int fib(int input){
        if(input == 1 || input == 2) {
            count1++;
            return 1;
        }
        else return (fib(input - 1) + fib(input - 2));
    }
}