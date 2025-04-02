

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[]number = new int[a + 1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1;i<=a;i++) number[i] = Integer.parseInt(st2.nextToken());
        for(int i=2;i<=a;i++) number[i] += number[i-1];

        int max = Integer.MIN_VALUE;
        for(int i=b;i<=a;i++){
            max = Math.max(max, number[i] - number[i - b]);
        }
        System.out.println(max);
    }
}