

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp1 = Integer.parseInt(st.nextToken());
        int temp2 = Integer.parseInt(st.nextToken());
        int temp3 = Integer.parseInt(st.nextToken());

        int sum = temp1+temp2+temp3;
        int max = Math.max(Math.max(temp1, temp2), temp3);

        if(max >= sum - max){
            System.out.println((sum-max) + (sum-max-1));
        }
        else{
            System.out.println(sum);
        }
    }
}