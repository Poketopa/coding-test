

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        int answerStart = 0;
        int answerEnd = 0;
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        int start = 0;
        int end = input - 1;
        int min = Integer.MAX_VALUE;
        while(start < end){
            if(min > Math.abs(number[start] + number[end])){
                min = Math.abs(number[start] + number[end]);
                answerStart = number[start];
                answerEnd = number[end];
            }
            if(number[start] + number[end] > 0) end--;
            else start++;
        }
        System.out.println(answerStart + " " + answerEnd);
    }
}