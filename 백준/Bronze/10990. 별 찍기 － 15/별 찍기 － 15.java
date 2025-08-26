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

        for(int i=0;i<input-1;i++)System.out.print(" ");
        System.out.println("*");
        for(int i=0;i<input-1;i++){
            for(int j=i;j<input-2;j++) System.out.print(" ");
            System.out.print("*");
            for(int j=0;j<(i*2) + 1;j++) System.out.print(" ");
            System.out.println("*");
        }
    }
}
