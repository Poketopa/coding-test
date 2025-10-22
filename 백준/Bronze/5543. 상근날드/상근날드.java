import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] ham = new int[3];
        
        int[] drink = new int[2];
        
        for(int i=0;i<3;i++) ham[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<2;i++) drink[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(ham);
        Arrays.sort(drink);
        System.out.print(ham[0] + drink[0] - 50);
    }
}






