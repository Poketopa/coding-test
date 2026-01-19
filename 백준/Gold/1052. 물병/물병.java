import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = Long.parseLong(st.nextToken());
        long bottle = Long.parseLong(st.nextToken());

        while(true){
            long two = 1;

            while(two <= sum){
                two *= 2;
            }
            two /= 2;

            sum -= two;
            bottle--;

            if(bottle == 0){
                if(sum == 0){
                    System.out.print("0");
                } else  System.out.print(two - sum);
                return;
            }
        }
    }
}
