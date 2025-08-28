import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        if(input == 1) {
            System.out.print("*");
            return;
        }

        for(int i=0;i<input*2;i++){
            for(int j=0;j<input;j++){
                if(((i % 2) + j) % 2 == 0) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
