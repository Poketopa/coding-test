import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String num1 = br.readLine();
        String math = br.readLine();
        String num2 = br.readLine();

        BigInteger br1 = new BigInteger(num1);
        BigInteger br2 = new BigInteger(num2);
        if(math.equals("*")){
            System.out.print(br1.multiply(br2).toString());
        } else {
            System.out.print(br1.add(br2).toString());
        }
    }
}
