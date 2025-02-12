import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int now = 1;
        int count = 0;


        while(true){
            if(String.valueOf(now).contains("666")) count++;
            if(count == input){
                System.out.println(now);
                return;
            }
            now++;
        }

    }
}