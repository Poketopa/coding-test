
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int temp1 = Integer.parseInt(br.readLine());
        int temp2 = Integer.parseInt(br.readLine());
        int temp3 = Integer.parseInt(br.readLine());
        int sum = 0;
        if(temp1==temp2) sum++;
        else if(temp2 == temp3) sum++;
        else if(temp1==temp3) sum++;


        if(temp1 == 60 && temp2 == 60 && temp3 == 60){
            System.out.println("Equilateral");
        }
        else if(temp1 + temp2 + temp3 == 180 && sum == 1) System.out.println("Isosceles");
        else if(temp1 + temp2 + temp3 == 180 && sum == 0) System.out.println("Scalene");
        else System.out.println("Error");
    }
}