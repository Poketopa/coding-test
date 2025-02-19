

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[5];
        int sum = 0;
        for(int i=0;i<5;i++){
            number[i] = Integer.parseInt(br.readLine());
            sum += number[i];
        }
        Arrays.sort(number);
        System.out.println(sum / 5+" "+number[2]);

    }
}