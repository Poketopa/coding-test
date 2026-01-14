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

        for(int i=0;i<3;i++){
            long input = Long.parseLong(br.readLine());
            BigInteger sum = new BigInteger("0");
            for(int j=0;j<input;j++){
                BigInteger number =  new BigInteger(br.readLine());
                sum = sum.add(number);
            }
            int result = sum.compareTo(BigInteger.ZERO);
            if(result == 0){
                System.out.println("0");
            } else if(result > 0){
                System.out.println("+");
            } else{
                System.out.println("-");
            }
        }
    }
}
