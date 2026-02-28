import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger[] arr = new BigInteger[251];
        arr[0] = new BigInteger("1");
        arr[1] = new BigInteger("1");
        arr[2] = new BigInteger("3");
        arr[3] = new BigInteger("5");

        for (int i = 4; i <= 250; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2].multiply(new BigInteger("2")));
        }

        String input;
        while ((input = br.readLine()) != null) {

            System.out.println(arr[Integer.parseInt(input)]);
        }
    }
}
