import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        int a = 0;
        int b = 0;
        int maxA = -1;
        int maxB = -1;
        for(int i=0;i<input;i++){
            if(list.get(i) > maxA){
                a++;
                maxA = list.get(i);
            }
            if(list.get(input - i -1) > maxB){
                b++;
                maxB = list.get(input - i - 1);
            }
        }

        System.out.print(a + "\n" + b);
    }
}
