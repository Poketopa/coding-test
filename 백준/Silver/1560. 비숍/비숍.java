import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger input = new BigInteger(br.readLine());

        if(input.equals(new BigInteger("1"))) {
            System.out.print("1");
            return;
        } else if(input.equals(new BigInteger("2"))){
            System.out.print("2");
            return;
        }

        BigInteger answer = input.multiply(new BigInteger("2")).subtract(new BigInteger("2"));
        System.out.print(answer);
    }
}
