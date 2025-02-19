

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            int temp3 = Integer.parseInt(st.nextToken());
            if(temp1==0&&temp2==0&&temp3==0) return;
            int sum = 0;
            if(temp1==temp2) sum++;
            if(temp2 == temp3) sum++;
            if(temp1==temp3) sum++;

            int lengthSum = temp1 +temp2+temp3;
            int max = Math.max(Math.max(temp1, temp2), temp3);
            if(lengthSum-max <= max){
                System.out.println("Invalid");
                continue;
            }

            if(sum == 3){
                System.out.println("Equilateral");
            }
            else if(sum == 1) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }

    }
}