
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        int count = 1;
        for(int i=1;i<=number;i++){
            if(number % i == 0){
                if(count == input){
                    System.out.println(i);
                    return;
                }
                else count++;
            }
        }
        System.out.println("0");
    }
}