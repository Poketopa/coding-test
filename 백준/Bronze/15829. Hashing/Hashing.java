import java.io.*;
import java.util.*;

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
        long sum = 0;
        for(int i=0;i<number.length;i++){
            sum += (long)(number[i] * (long)Math.pow(31, i)) % 1234567891;
        }

        System.out.println(sum);


    }
}