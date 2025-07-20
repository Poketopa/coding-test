import java.io.*;
import java.util.*;

public class Main {
    static long pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        draw(input, 1);

    }
    public static void draw(int input, int now){
        if(now == input + 1) return;

        for(int i=0;i<now;i++){
            System.out.print("*");
        }
        for(int i=0;i<(input - now) * 2;i++){
            System.out.print(" ");
        }
        for(int i=0;i<now;i++){
            System.out.print("*");
        }
        System.out.println(" ");

        draw(input, now + 1);
        if(now == input) return;

        for(int i=0;i<now;i++){
            System.out.print("*");
        }
        for(int i=0;i<(input - now) * 2;i++){
            System.out.print(" ");
        }
        for(int i=0;i<now;i++){
            System.out.print("*");
        }
        System.out.println(" ");
    }
}
