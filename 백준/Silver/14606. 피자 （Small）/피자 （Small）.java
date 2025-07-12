import java.io.*;
import java.util.*;

public class Main {
    static int pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        makePizza(input);
        System.out.println(pleasure);
    }
    public static void makePizza(int input){
        if(input == 1) return;

        int half = input / 2;

        pleasure += half * (input - half);

        makePizza(half);
        makePizza(input - half);
    }
}