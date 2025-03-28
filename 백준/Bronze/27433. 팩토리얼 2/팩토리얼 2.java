

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        long number = 1;
        int input = Integer.parseInt(br.readLine());
        for(int i=1;i<=input;i++){
            number *= i;
        }
        System.out.println(number);
    }
}