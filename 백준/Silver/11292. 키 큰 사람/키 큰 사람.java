import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) return;
            List<String> name = new ArrayList<>();
            List<Double> tall = new ArrayList<>();
            double max = Double.MIN_VALUE;
            for(int i=0;i<input;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                name.add(st.nextToken());
                tall.add(Double.parseDouble(st.nextToken()));
                max = Math.max(max, tall.get(i));
            }
            for(int i=0;i<input;i++){
                if(tall.get(i).equals(max)){
                    System.out.print(name.get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}
