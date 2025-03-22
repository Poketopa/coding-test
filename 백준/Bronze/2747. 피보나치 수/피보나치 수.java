

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int prevNum = 0;
        int nextNum = 1;

        for(int i=0;i<input;i++){
            int swap = nextNum;
            nextNum += prevNum;
            prevNum = swap;
        }
        System.out.println(prevNum);
    }
}