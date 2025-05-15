import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        double[] number = new double[input];
        for(int i=0;i<input;i++) number[i] = Double.parseDouble(br.readLine());
        double max = Double.MIN_VALUE;
        for(int i=0;i<input;i++){
            double temp = 1;
            for(int j=i;j<input;j++){
                temp *= number[j];
                max = Math.max(temp, max);
            }

        }
        System.out.printf("%.3f", max);
    }
}
