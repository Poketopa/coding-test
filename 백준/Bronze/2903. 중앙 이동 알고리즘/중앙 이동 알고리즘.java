
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(br.readLine());
        
        int temp = (int)Math.pow(2, number) + 1;
        System.out.println((int)Math.pow(temp, 2));
    }
}