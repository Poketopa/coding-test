
import java.io.*;
import java.util.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        while(input >= 500){
            count++;
            input -= 500;
        }
        while(input >= 100){
            count++;
            input -= 100;
        }
        while(input >= 50){
            count++;
            input -= 50;
        }
        while(input >= 10){
            count++;
            input -= 10;
        }
        while(input >= 5){
            count++;
            input -= 5;
        }
        while(input >= 1){
            count++;
            input -= 1;
        }
        System.out.println(count);
    }
}