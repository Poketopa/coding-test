

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int[] rope = new int[input];
        for(int i=0;i<input;i++){
            int temp = Integer.parseInt(br.readLine());
            rope[i] = temp;
        }
        Arrays.sort(rope);
        int sum = 0;
        int max = -1;
        int count = 1;
        for(int i=rope.length-1;i>=0;i--){
            max = Math.max(rope[i] * count, max);
            count++;
        }
        System.out.println(max);
    }
}