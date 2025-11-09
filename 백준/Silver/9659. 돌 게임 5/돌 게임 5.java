import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        // 2의 배수면 창영 승
        // 1 -> 상근
        // 2 -> 상근
        // 3 -> 상근
        // 4 -> 창영
        // 5 -> 상근
        // 6 -> 창영
        // 7 -> 상근
        // 8 -> 창영
        long input = Long.parseLong(br.readLine());
        if(input == 1){
            System.out.print("SK");
            return;
        }
        if(input %2 == 0) System.out.print("CY");
        else System.out.print("SK");
    }
}
