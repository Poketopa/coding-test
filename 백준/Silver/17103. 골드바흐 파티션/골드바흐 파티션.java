import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        sieveOfEratosthenes();
        int input = Integer.parseInt(br.readLine());
        for(int repeat = 0;repeat < input;repeat++){
            int number = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i=2;i<=number / 2;i++){
                if(isPrime[i] && isPrime[number - i]){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void sieveOfEratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i <= Math.sqrt(1000000); i++){
            if(isPrime[i]){
                for(int j = i * i; j <= 1000000; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
}
