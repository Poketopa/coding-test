

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        for(int i=0;i<input;i++){
            for(int j=i;j<input-1;j++) System.out.print(" ");
            for(int j=0;j<(i*2)+1;j++) System.out.print("*");
            System.out.println("");
        }

        for(int i=0;i<input-1;i++){
            for(int j=0;j<i+1;j++) System.out.print(" ");
            for(int j=0;j<(input-2-i) * 2 + 1;j++) System.out.print("*");
            System.out.println("");
        }
    }
}