import java.io.*;
import java.util.*;

public class Main {
    static long pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            for(int j=0;j<input - i - 1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<(i*2) +1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }


    }
}
