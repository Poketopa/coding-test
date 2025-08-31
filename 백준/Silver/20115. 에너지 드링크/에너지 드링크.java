import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        double[] drink = new double[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) drink[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(drink);

        double sum = 0;

        for(int i=0;i<input-1;i++){
            sum += drink[i]/2;
        }

        sum += drink[input-1];

        System.out.print(sum);
    }
}
