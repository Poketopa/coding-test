import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String dummy = br.readLine();
        String input = br.readLine();
        int[] number = new int[input.length()];
        for(int i=0;i<number.length;i++){
            number[i] = (int)input.charAt(i) - 96;
        }
        BigInteger sum = BigInteger.valueOf(0);
        for(int i=0;i<number.length;i++){
            sum = sum.add(BigInteger.valueOf(number[i]).multiply(BigInteger.valueOf(31).pow(i))).remainder(BigInteger.valueOf(1234567891));
        }

        System.out.println(sum);


    }
}
